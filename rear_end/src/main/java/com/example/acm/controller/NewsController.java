package com.example.acm.controller;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.User;
import com.example.acm.service.deal.NewsDealService;
import com.example.acm.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xgg on 2019/1/19.
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    public NewsDealService newsDealService;

    @RequestMapping(value = "/addNewMain", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addNews(@RequestParam(value="newsTitle", required = true) String newsTitle,
                              @RequestParam(value="newsBody", required = true) String newsBody,
                              @RequestParam(value="isPublic", required = true) int isPublic,
                              @RequestParam(value="classType", required = true) String classType,

                              HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            newsBody = StringUtils.getHtml(newsBody);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }
            return newsDealService.addNews(user, newsTitle, newsBody, isPublic, classType);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping(value = "/updateNewMain", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean updateNewMain(@RequestParam(value="newsId", required = true) long newsId,
                                     @RequestParam(value="newsTitle", required = true) String newsTitle,
                                     @RequestParam(value="newsBody", required = true) String newsBody,
                                     @RequestParam(value="isPublic", required = true) int isPublic,
                                    @RequestParam(value="classType", defaultValue = "", required = false) String classType,
                                     HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            newsBody = StringUtils.getHtml(newsBody);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }

            return newsDealService.updateNews(user, newsId, newsTitle, newsBody, isPublic, classType);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping(value = "/deleteNewMain", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean deleteNewMain(@RequestParam(value="newsId", required = true) long newsId,
                                    HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }

            return newsDealService.deleteNews(user, newsId);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping("/selectNewsMain")
    @ResponseBody
    public ResultBean selectNewsMain(@RequestParam(value = "newsTitle", defaultValue = "", required = false) String newsTitle,
                                     @RequestParam(value="aOrs", defaultValue = "1", required = false) int aOrs,
                                     @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                     @RequestParam(value="order", defaultValue = "createDate", required = false) String order,
                                     @RequestParam(value="pageSize", defaultValue="10", required = false) int pageSize,
                                     @RequestParam(value = "isPublic", defaultValue = "-1", required = false) int isPublic,
                                     HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }

            return newsDealService.selectNews(newsTitle,  aOrs,  order,  pageNum,  pageSize, isPublic);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean detail(@RequestParam(value="newsId", required = true) long newsId,
                                    HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }

            return newsDealService.detail(user, newsId);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }
}
