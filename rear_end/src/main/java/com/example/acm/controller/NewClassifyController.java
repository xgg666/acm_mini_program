package com.example.acm.controller;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.Classification;
import com.example.acm.entity.User;
import com.example.acm.service.ClassificationService;
import com.example.acm.service.deal.ClassificationDealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
 * Created by xgg on 2019/1/10.
 */
@Controller
@RequestMapping(value = "/news")
public class NewClassifyController extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(NewClassifyController.class);
    @Autowired
    public ClassificationDealService classificationDealService;
    @Autowired
    public ClassificationService classificationService;

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addNews(@RequestParam(value = "name", required = true) String name,
                              HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }
            return classificationDealService.addClassify(user, name);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping("/selectClass")
    @ResponseBody
    public ResultBean selectClass(@RequestParam(value = "className", defaultValue = "", required = false) String className,
                                    @RequestParam(value="aOrs", defaultValue = "1", required = false) int aOrs,
                                  @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                  @RequestParam(value="order", defaultValue = "createTime", required = false) String order,
                                  @RequestParam(value="pageSize", defaultValue="10", required = false) int pageSize,
                                  HttpServletRequest request, HttpServletResponse response) {
        try {
            User user =getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }

            return classificationDealService.selectClass(user, className, aOrs, order, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping(value = "/deleteNews")
    @ResponseBody
    public ResultBean selectClass(@RequestParam(value = "classId", required = true) long classId,
                                  HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = getUserIdFromSession(request);
            if (user == null) {
                return new ResultBean(ResultCode.SESSION_OUT);
            }
            if (user.getAuth() < SysConst.ADMIN) {
                return new ResultBean(ResultCode.USER_NOT_ADMIN);
            }

            return classificationDealService.deleteClass(user, classId);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }
}
