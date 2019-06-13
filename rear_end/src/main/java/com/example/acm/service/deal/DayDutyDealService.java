package com.example.acm.service.deal;

import com.example.acm.common.ResultBean;
import com.example.acm.entity.User;

/**
 * Created by xgg on 2019/2/14.
 */
public interface DayDutyDealService {
    ResultBean selectDayDuty();

    ResultBean updateDayDuty(User user, int dayDutyId, String dutyUserNames);

    ResultBean detailDayDuty(User user, int dayDutyId);
}
