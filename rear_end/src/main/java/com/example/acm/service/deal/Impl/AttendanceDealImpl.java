package com.example.acm.service.deal.Impl;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.Attendance;
import com.example.acm.entity.User;
import com.example.acm.service.AttendanceService;
import com.example.acm.service.deal.AttendanceDealService;
import com.example.acm.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xgg on 2019/3/29.
 */
@Service
public class AttendanceDealImpl implements AttendanceDealService{

    private static final Logger LOG = LoggerFactory.getLogger(AttendanceDealImpl.class);

    @Autowired
    private AttendanceService attendanceService;

    public ResultBean addAttendance(User user) {

        Map<String, Object> map = new HashMap<>();

        map.put("createUser", user.getUserId());
        map.put("order", "createDate");
        map.put("order", "createDate");
        map.put("aOrS", "DESC");
        map.put("isEffective", SysConst.LIVE);
        map.put("start", 0);
        map.put("limit", 1);

        List<Attendance> attendances = attendanceService.findAttendanceListByQuery(map);
        if (attendances.size()==0) {
            Attendance add = new Attendance();
            add.setCreateUser(user.getUserId().longValue());
            add.setCreateDate(new Date());
            add.setSumDay(1);
            add.setIsEffective(SysConst.LIVE);

            attendanceService.addAttendance(add);

            return new ResultBean(ResultCode.SUCCESS, "连续签到1天");
        } else {
            Attendance attendance = attendances.get(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String date1 = sdf.format(attendance.getCreateDate());
            String date2 = sdf.format(new Date());
            LOG.info(date1+"---"+date2);
            if (date1.equals(date2)) {
                return new ResultBean(ResultCode.SYSTEM_FAILED, "今天已签到");
            }
            Date date = new Date();
            int dif = DateUtils.differentDays(attendance.getCreateDate(), date);
            LOG.info("差"+dif);
            int day = 1;
            if (dif==1) {
                day = attendance.getSumDay()+1;
            }
            Attendance add = new Attendance();
            add.setCreateUser(user.getUserId().longValue());
            add.setCreateDate(new Date());
            add.setSumDay(day);
            add.setIsEffective(SysConst.LIVE);

            attendanceService.addAttendance(add);

            return new ResultBean(ResultCode.SUCCESS, "连续签到"+day+"天");
        }

    }
}
