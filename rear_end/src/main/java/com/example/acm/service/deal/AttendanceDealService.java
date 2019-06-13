package com.example.acm.service.deal;

import com.example.acm.common.ResultBean;
import com.example.acm.entity.User;

/**
 * Created by xgg on 2019/3/29.
 */
public interface AttendanceDealService {

    ResultBean addAttendance(User user);
}
