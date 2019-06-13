package com.example.acm.service.deal.Impl;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.controller.AnnouncementCOntroller;
import com.example.acm.entity.Announcement;
import com.example.acm.entity.User;
import com.example.acm.service.AnnouncementService;
import com.example.acm.service.UserService;
import com.example.acm.service.deal.AnnounceDealService;
import com.example.acm.utils.DateUtils;
import com.example.acm.utils.ListPage;
import com.example.acm.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xgg on 2019/1/13.
 */
@Service
public class AnnounceDealImpl implements AnnounceDealService{

    private static final Logger LOG = LoggerFactory.getLogger(AnnounceDealImpl.class);
    @Autowired
    public AnnouncementService announcementService;
    @Autowired
    public UserService userService;

    @Transactional
    public ResultBean addAnnounce(User user, String announceTitle, String announceBody, int isPublic){
        try {
            Announcement announcement = new Announcement();
            Long bigInteger = new Long(UUIDUtil.getNumUUID());

            announcement.setAnnounceId(bigInteger);
            announcement.setAnnounceTitle(announceTitle);
            announcement.setAnnounceBody(announceBody);
            announcement.setAnnounceCreateTime(new Date());
            announcement.setAnnounceCreateUser(user.getUserId().longValue());
            announcement.setAnnounceUpdateTime(new Date());
            announcement.setAnnounceUpdateUser(user.getUserId().longValue());
            announcement.setIsEffective(1);
            announcement.setIsFirst(0);
            announcement.setIsPublic(isPublic);

            announcementService.addAnnouncement(announcement);

            return new ResultBean(ResultCode.SUCCESS, bigInteger);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @Transactional
    public ResultBean updateAnnounce(User user, long announceId, String announceTitle, String announceBody, int isPublic){
        try {
            List<Announcement> list = announcementService.findAnnouncementListByAnnounceId(announceId);
            if (list.size()==0) {
                LOG.info("该id不存在");
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该公告");
            }
            Announcement announcement = new Announcement();
            announcement.setAnnounceTitle(announceTitle);
            announcement.setAnnounceBody(announceBody);
            announcement.setAnnounceUpdateTime(new Date());
            announcement.setAnnounceUpdateUser(user.getUserId().longValue());
            announcement.setIsPublic(isPublic);

            announcementService.updateAnnouncementByAnnounceId(announceId, announcement);

            return new ResultBean(ResultCode.SUCCESS, announceId);
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean selectAnnounce(String announceTitle, int aOrs, String order, int pageNum, int pageSize){
        try {
            Map<String, Object> map = new HashMap<>();
            if (pageNum < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "页码不能小于0");
            }
            if (pageSize < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "一页展示数量不能小于0");
            }
            int start = (pageNum - 1) * pageSize;
            int limit = pageSize;
            map.put("announceTitle", announceTitle);
            map.put("start", start);
            map.put("limit", limit);
            map.put("order", order);
            if (aOrs == 1) {
                map.put("aOrS", "DESC");
            } else {
                map.put("aOrS", "ASC");
            }
            map.put("isEffective", 1);
            List<Map<String, Object>> list = announcementService.findAnnouncementMapListByQuery(map);

            if (list.size() >0) {
                for (Map<String, Object> mapTemp : list) {
                    mapTemp.put("announceCreateTime", DateUtils.convDateToStr((Date) mapTemp.get("announceCreateTime"), "yyyy/MM/dd HH:mm:ss"));
                    mapTemp.put("announceUpdateTime", DateUtils.convDateToStr((Date) mapTemp.get("announceUpdateTime"), "yyyy/MM/dd HH:mm:ss"));
                    List<User> users = userService.findUserListByUserId(Integer.parseInt(mapTemp.get("announceCreateUser").toString()));
                    if (users.size() != 0) {
                        mapTemp.put("announceCreateUser", users.get(0).getUsername());
                    }
                }
            }

            int allNum = announcementService.countAnnouncementListByQuery(map);

            ListPage<List<Map<String, Object>>> listPage = ListPage.createListPage(pageNum, pageSize, allNum, list);

            return new ResultBean(ResultCode.SUCCESS, listPage);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.OTHER_FAIL);
        }
    }

    public ResultBean deleteAnnounce(User user, long announceId){
        try {
            List<Announcement> list = announcementService.findAnnouncementListByAnnounceId(announceId);
            if (list.size()==0) {
                LOG.info("该id不存在");
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该公告");
            }
            Announcement announcement = new Announcement();
            announcement.setIsEffective(0);

            announcementService.updateAnnouncementByAnnounceId(announceId, announcement);

            return new ResultBean(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.OTHER_FAIL);
        }
    }

    public ResultBean detail(User user, long announceId){
        try {
            List<Map<String, Object>> list = announcementService.findAnnouncement2MapListByAnnounceId(announceId);
            if (list.size()==0) {
                LOG.info("该id不存在");
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该公告");
            }
            list = DateUtils.changeDateNormal(list, "announceUpdateTime", "announceCreateTime");

            return new ResultBean(ResultCode.SUCCESS, list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.OTHER_FAIL);
        }
    }

    public ResultBean updateFirst(User user, long announceId){
        try {
            List<Announcement> list = announcementService.findAnnouncementListByAnnounceId(announceId);
            if (list.size()==0) {
                LOG.info("该id不存在");
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该公告");
            }
            Announcement announcement = list.get(0);
            if (announcement.getIsPublic()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "该公告尚未发布，不能置顶");
            }
            int isFirst = 1;
            if (announcement.getIsFirst()==1) {
                isFirst=0;
            }
            announcement.setIsFirst(isFirst);
            announcementService.updateAnnouncementByAnnounceId(announceId, announcement);
            return new ResultBean(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.OTHER_FAIL);
        }
    }
}
