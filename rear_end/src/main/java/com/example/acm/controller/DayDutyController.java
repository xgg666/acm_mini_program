package com.example.acm.controller;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.User;
import com.example.acm.service.deal.DayDutyDealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xgg on 2019/2/14.
 */
@Controller
@RequestMapping("/dayDuty")
public class DayDutyController extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(DayDutyController.class);

    @Autowired
    private DayDutyDealService dayDutyDealService;

    @RequestMapping("/selectDayDuty")
    @ResponseBody
    public ResultBean selectDayDuty(HttpServletRequest request, HttpServletResponse response) {
        try{
            return dayDutyDealService.selectDayDuty();
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    @RequestMapping("/updateDayDuty")
    @ResponseBody
    public ResultBean updateDayDuty(@RequestParam(value = "dayDutyId", required = true) int dayDutyId,
                                    @RequestParam(value="dutyUserNames",  required = false) String dutyUserNames,
                                    HttpServletRequest request, HttpServletResponse response) {
        User user = getUserIdFromSession(request);
        if (user == null) {
            return new ResultBean(ResultCode.SESSION_OUT);
        }
        if (user.getAuth()< SysConst.ADMIN) {
            return new ResultBean(ResultCode.USER_NOT_ADMIN);
        }

        return dayDutyDealService.updateDayDuty(user, dayDutyId, dutyUserNames);
    }

    @RequestMapping("/detailDayDuty")
    @ResponseBody
    public ResultBean detailDayDuty(@RequestParam(value = "dayDutyId", required = true) int dayDutyId,
                                    HttpServletRequest request, HttpServletResponse response) {
        User user = getUserIdFromSession(request);
        if (user == null) {
            return new ResultBean(ResultCode.SESSION_OUT);
        }
        return dayDutyDealService.detailDayDuty(user, dayDutyId);
    }
}
