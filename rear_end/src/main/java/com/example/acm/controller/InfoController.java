package com.example.acm.controller;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.DayDuty;
import com.example.acm.entity.User;
import com.example.acm.mapper.ImpressionMapper;
import com.example.acm.mapper.UserMapper;
import com.example.acm.returnView.UserImpression;
import com.example.acm.service.*;
import com.example.acm.utils.DateUtils;
import com.example.acm.utils.ObjectUtils;
import com.example.acm.view.ChartView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.geom.RectangularShape;
import java.util.*;

/**
 * Created by xgg on 2019/4/9.
 */

@Controller
@RequestMapping("/info")
public class InfoController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private DayDutyService dayDutyService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImpressionMapper impressionMapper;


    @RequestMapping("/getIndexInfo")
    @ResponseBody
    public ResultBean getIndexInfo(HttpServletRequest request, HttpServletResponse response) {
        User user = getUserIdFromSession(request);
        if (user == null) {
             return new ResultBean(ResultCode.SESSION_OUT);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("isEffective", SysConst.LIVE);

        int allUserNum = userService.countUserMapListByQuery(map);


        Date today = new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK);
        weekday = (weekday+7-1)%7;
        if (weekday==0) {
            weekday=7;
        }
        List<DayDuty> dayDuties = dayDutyService.findDayDutyListByDayDutyId(weekday);


        String nowDuty =dayDuties.get(0).getDutyUserNames();

        map.put("allUserNum", allUserNum);
        map.put("nowDuty", nowDuty);


        map.put("isEffective", 1);
        int allNum = userService.countUserMapListByQuery(map);
        System.out.println("allNum---------"+allNum);
        int start = 0;
        int limit = 5;
        map.put("start", start);
        map.put("limit", limit);
        List<Map<String, Object>> users = userMapper.findUserBuImpressionSort(map);

        System.out.println("--------"+users.size());
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (Map<String , Object> tmp: users ) {
            Map<String, Object> mm = new HashMap<>();
            mm.put("userId", tmp.get("userId"));
            mm.put("isEffective", 1);
            mm.put("start", start);
            mm.put("limit", 3);
            List<UserImpression> tt = impressionMapper.findUserImpression(mm);
            if (tt.size()==0) {
                continue;
            }
            list1.add(ObjectUtils.objectToMap(tt.get(0)));
        }
        map.put("impression", list1);

        return new ResultBean(ResultCode.SUCCESS, map);
    }

    @RequestMapping("/selectNewsAndAnnoun")
    @ResponseBody
    public ResultBean getNewsAndAnnoun(HttpServletRequest request, HttpServletResponse response) {
        User user = getUserIdFromSession(request);
        if (user == null) {
             return new ResultBean(ResultCode.SESSION_OUT);
        }
        if (user.getAuth() < SysConst.NORMAL) {
            return new ResultBean(ResultCode.USER_NOT_ADMIN);
        }

        Map<String, Object> map = new HashMap<>();
        int start = 0;
        int limit = 5;
        map.put("start", start);
        map.put("limit", limit);
        map.put("order", "announceUpdateTime");
        map.put("aOrS", "DESC");
        map.put("isPublic", 1);
        map.put("isEffective", 1);
        List<Map<String, Object>> announ_list = announcementService.findAnnouncementMapListByQuery(map);

        map.put("order", "updateDate");
        List<Map<String, Object>> news_list = newsService.findNewsMapListByQuery(map);

        map.put("order", "createDate");
        List<Map<String, Object>> competition_list = competitionService.findCompetitionMapListByQuery(map);
        announ_list = DateUtils.changeDateNormal(announ_list, "announceCreateTime", "announceUpdateTime");
        news_list = DateUtils.changeDateNormal(news_list, "updateDate", "createDate");
        competition_list = DateUtils.changeDateNormal(competition_list, "updateDate", "createDate");

        Map<String, Object> data_map = new HashMap<>();
        data_map.put("news", news_list);
        data_map.put("announ", announ_list);
        data_map.put("competition", competition_list);
        return new ResultBean(ResultCode.SUCCESS, data_map);
    }
}
