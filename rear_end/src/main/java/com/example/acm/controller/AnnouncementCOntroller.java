package com.example.acm.controller;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.Announcement;
import com.example.acm.entity.User;
import com.example.acm.service.AnnouncementService;
import com.example.acm.service.deal.AnnounceDealService;
import com.example.acm.utils.ListPage;
import com.example.acm.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xgg on 2019/1/13.
 */
@Controller
@RequestMapping("/announce")
public class AnnouncementCOntroller extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(AnnouncementCOntroller.class);

    @Autowired
    public AnnounceDealService announceDealService;

    @RequestMapping(value = "/addAnnounce", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addNews(@RequestParam(value = "announceTitle", required = true) String announceTitle,
                               @RequestParam(value = "announceBody", required = true) String announceBody,
                              @RequestParam(value = "isPublic", defaultValue = "0", required = false) int isPublic,
                              HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            announceBody = StringUtils.getHtml(announceBody);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }
            return announceDealService.addAnnounce(user, announceTitle, announceBody, isPublic);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping(value = "/updateAnnounce", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean updateAnnounce(@RequestParam(value = "announceId", required = true) long announceId,
                                      @RequestParam(value = "announceTitle", required = true) String announceTitle,
                                      @RequestParam(value = "announceBody", required = true) String announceBody,
                                      @RequestParam(value = "isPublic", defaultValue = "0", required = false) int isPublic,
                                      HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            announceBody = StringUtils.getHtml(announceBody);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }
            return announceDealService.updateAnnounce(user, announceId, announceTitle, announceBody, isPublic);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping("/selectAnnounce")
    @ResponseBody
    public ResultBean selectAnnounce(@RequestParam(value = "announceTitle", defaultValue = "", required = false) String announceTitle,
                                     @RequestParam(value="aOrs", defaultValue = "1", required = false) int aOrs,
                                     @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                     @RequestParam(value="order", defaultValue = "announceCreateTime", required = false) String order,
                                     @RequestParam(value="pageSize", defaultValue="10", required = false) int pageSize,
                                     HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }

            return announceDealService.selectAnnounce(announceTitle,  aOrs,  order,  pageNum,  pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping(value = "/deleteAnnounce")
    @ResponseBody
    public ResultBean selectClass(@RequestParam(value = "announceId", required = true) long announceId,
                                  HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }

            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }
            return announceDealService.deleteAnnounce(user, announceId);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public ResultBean detail(@RequestParam(value = "announceId", required = true) long announceId,
                                  HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }

            return announceDealService.detail(user, announceId);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    //修改置顶状态
    @RequestMapping(value = "/updateFirst")
    @ResponseBody
    public ResultBean updateFirst(@RequestParam(value = "announceId", required = true) long announceId,
                             HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }

            return announceDealService.updateFirst(user, announceId);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }
}
