package com.example.acm.service.deal.Impl;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.Impression;
import com.example.acm.entity.User;
import com.example.acm.mapper.ImpressionMapper;
import com.example.acm.mapper.UserMapper;
import com.example.acm.returnView.UserImpression;
import com.example.acm.service.ImpressionService;
import com.example.acm.service.UserService;
import com.example.acm.service.deal.ImpressionDealService;
import com.example.acm.utils.DateUtils;
import com.example.acm.utils.ListPage;
import com.example.acm.utils.ObjectUtils;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by xgg on 2019/4/11.
 */
@Service
public class ImpressionDealImpl implements ImpressionDealService{

    @Autowired
    private UserService userService;
    @Autowired
    private ImpressionService impressionService;

    public ResultBean addImpression(int userId, String impressionTitle, User user) {
        List<User> users = userService.findUserListByUserId(userId);
        if (users.size()==0) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该用户");
        }
        User imUser = users.get(0);
        if (imUser.getIsEffective()== SysConst.NOT_LIVE) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该用户");
        }

        Impression impression = new Impression();
        impression.setImpressionTitle(impressionTitle);
        impression.setImUser(userId);
        impression.setCreateUser(user.getUserId());
        impression.setCreateDate(new Date());
        impression.setAgreeNum(0);
        impression.setIsEffective(SysConst.LIVE);

        impressionService.addImpression(impression);

        return new ResultBean(ResultCode.SUCCESS);
    }

    public ResultBean deleteImpression(long impressionId, User user) {
        List<Impression> impressions = impressionService.findImpressionListByImpressionId(impressionId);

        if (impressions.size()==0) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该印象");
        }
        Impression impression = impressions.get(0);

        if (impression.getIsEffective()==SysConst.NOT_LIVE) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该印象");
        }

        impression.setIsEffective(SysConst.NOT_LIVE);
        impressionService.updateImpressionByImpressionId(impressionId, impression);

        return new ResultBean(ResultCode.SUCCESS);
    }

    public ResultBean agreeImpression(long impressionId, User user) {
        List<Impression> impressions = impressionService.findImpressionListByImpressionId(impressionId);

        if (impressions.size()==0) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该印象");
        }
        Impression impression = impressions.get(0);

        if (impression.getIsEffective()==SysConst.NOT_LIVE) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该印象");
        }

        impression.setAgreeNum(impression.getAgreeNum()+1);
        impressionService.updateImpressionByImpressionId(impressionId, impression);

        return new ResultBean(ResultCode.SUCCESS);
    }

    @Autowired
    private ImpressionMapper impressionMapper;
    @Autowired
    private UserMapper userMapper;

    public ResultBean selectImpression(User user, String name, int aOrs, String order, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", name);

        if (pageNum < 0) {
            return new ResultBean(ResultCode.PARAM_ERROR, "页码不能小于0");
        }
        if (pageSize < 0) {
            return new ResultBean(ResultCode.PARAM_ERROR, "一页展示数量不能小于0");
        }
        map.put("isEffective", 1);
        int allNum = userService.countUserMapListByQuery(map);
        System.out.println("allNum---------"+allNum);
        int start = (pageNum - 1) * pageSize;
        int limit = pageSize;
        map.put("start", start);
        map.put("limit", limit);
        List<Map<String, Object>> users = userMapper.findUserBuImpressionSort(map);

        System.out.println("--------"+users.size());
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (Map<String , Object> tmp: users ) {
            Map<String, Object> mm = new HashMap<>();
            mm.put("userId", tmp.get("userId"));
            mm.put("isEffective", 1);
            List<UserImpression> tt = impressionMapper.findUserImpression(mm);
            System.out.println("userid: " + tmp.get("userId") + " size: " + tt.size());
            if (tt.size()==0) {
                list1.add(tmp);
                continue;
            }
            list1.add(ObjectUtils.objectToMap(tt.get(0)));
        }

        ListPage<List<Map<String, Object>>> listPage = ListPage.createListPage(pageNum, pageSize, allNum, list1);
        return new ResultBean(ResultCode.SUCCESS, listPage);
    }

    public ResultBean userImpression(int userId, User user) {

        Map<String, Object> mm = new HashMap<>();
        User user1 = new User();
        if (userId!=-1) {
            List<User> users = userService.findUserListByUserId(userId);
            if (users.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该用户");
            }
            user1 = users.get(0);
            if (user1.getIsEffective()==SysConst.NOT_LIVE) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该用户");
            }
            mm.put("userId", userId);
        } else {
            mm.put("userId", user.getUserId());
        }


        mm.put("isEffective", 1);
        List<UserImpression> tt = impressionMapper.findUserImpression(mm);
        if (tt.size() == 0) {
            if (userId == -1) {
                return new ResultBean(ResultCode.SUCCESS, user);
            } else {
                return new ResultBean(ResultCode.SUCCESS, user1);
            }
        }
        return new ResultBean(ResultCode.SUCCESS, tt.get(0));
    }

    public ResultBean interestImpression(int userId, User user) {

        int uId = userId;
        if (userId==-1) {
            uId = user.getUserId();
        }
        Map<String, Object> map = new HashMap<>();

        map.put("isEffective", 1);
        int allNum = userService.countUserMapListByQuery(map);
        List<Map<String, Object>> users = userMapper.findUserBuImpressionSort(map);

        int u = -1;

        System.out.println("--------"+users.size());
        List<Map<String, Object>> ans = new ArrayList<>();
        int i = 0;
        for (Map<String , Object> tmp: users ) {
            Map<String, Object> mm = new HashMap<>();
            long userIdTmp = (long)tmp.get("userId");
            Boolean tmpp = (userIdTmp==uId);
            int m = (int)userIdTmp-uId;
            if ((int)userIdTmp==uId) {
                u = i;
                break;
            }
            i++;
        }

        if (u==-1) {
            return new ResultBean(ResultCode.PARAM_ERROR);
        }
         i = 0;
        for (Map<String , Object> tmp: users ) {
            Map<String, Object> mm = new HashMap<>();
            if (i==u) {
                i++; continue;
            }
            if (Math.abs(u-i)<=2) {
                ans.add(tmp);
            }
            i++;
        }

        return new ResultBean(ResultCode.SUCCESS, ans);
    }


    public ResultBean updateImpression(long impressionId, String impreeesionTitle, int agreeNum) {
        List<Impression> impressions = impressionService.findImpressionListByImpressionId(impressionId);

        if (impressions.size()==0) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该印象");
        }
        Impression impression = impressions.get(0);

        if (impression.getIsEffective()==SysConst.NOT_LIVE) {
            return new ResultBean(ResultCode.PARAM_ERROR, "不存在该印象");
        }
        if (impreeesionTitle == "") {
            return new ResultBean(ResultCode.PARAM_ERROR, "印象不能为空");
        }
        if (agreeNum < 0) {
            return new ResultBean(ResultCode.PARAM_ERROR, "点赞数输入范围错误");
        }
        impression.setAgreeNum(agreeNum);
        impression.setImpressionTitle(impreeesionTitle);
        impressionService.updateImpressionByImpressionId(impressionId, impression);

        return new ResultBean(ResultCode.SUCCESS);
    }
}
