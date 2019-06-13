package com.example.acm.controller;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.User;
import com.example.acm.service.deal.AttendanceDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xgg on 2019/3/29.
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController extends BaseController{

    @Autowired
    private AttendanceDealService attendanceDealService;

    @RequestMapping("/addAttandence")
    @ResponseBody
    public ResultBean addAttandence(HttpServletRequest request, HttpServletResponse response) {
        User user = getUserIdFromSession(request);
        if (user == null) {
            return new ResultBean(ResultCode.SESSION_OUT);
        }
        if (user.getAuth() < SysConst.NORMAL) {
            return new ResultBean(ResultCode.NO_OAUTH);
        }
        return attendanceDealService.addAttendance(user);
    }
}
