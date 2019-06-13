package com.example.acm.service.deal.Impl;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.entity.DayDuty;
import com.example.acm.entity.User;
import com.example.acm.service.DayDutyService;
import com.example.acm.service.deal.DayDutyDealService;
import com.example.acm.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xgg on 2019/2/14.
 */
@Service
public class DayDutyDealImpl implements DayDutyDealService{

    private static final Logger LOG = LoggerFactory.getLogger(DayDutyDealImpl.class);

    @Autowired
    private DayDutyService dayDutyService;

    public ResultBean selectDayDuty(){
        try {
            List<Map<String, Object>> list = dayDutyService.findDayDuty2MapList();

            if (list.size() >0) {
                for (Map<String, Object> mapTemp : list) {
                    mapTemp.put("updateData", DateUtils.convDateToStr((Date) mapTemp.get("updateData"), "yyyy-MM-dd HH:mm:ss"));
                    mapTemp.put("createDate", DateUtils.convDateToStr((Date) mapTemp.get("createDate"), "yyyy-MM-dd HH:mm:ss"));
                    }
            }
            return new ResultBean(ResultCode.SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }

    }

    public ResultBean updateDayDuty(User user, int dayDutyId, String dutyUserNames) {
        List<DayDuty> dayDuties = dayDutyService.findDayDutyListByDayDutyId(dayDutyId);

        if (dayDuties.size()<1) {
            LOG.info("没有此id的值日:"+dayDutyId);
            return new ResultBean(ResultCode.SYSTEM_FAILED, "没有此id的值日");
        }

        DayDuty dayDuty = dayDuties.get(0);
        dayDuty.setDutyUserNames(dutyUserNames);
        dayDuty.setUpdateUser(user.getUserId().intValue());
        dayDuty.setUpdateData(new Date());

        dayDutyService.updateDayDutyByDayDutyId(dayDutyId, dayDuty);

        return new ResultBean(ResultCode.SUCCESS);
    }

    public ResultBean detailDayDuty(User user, int dayDutyId){
        List<DayDuty> dayDuties = dayDutyService.findDayDutyListByDayDutyId(dayDutyId);

        if (dayDuties.size()<1) {
            LOG.info("没有此id的值日:"+dayDutyId);
            return new ResultBean(ResultCode.SYSTEM_FAILED, "没有此id的值日");
        }

        DayDuty dayDuty = dayDuties.get(0);

        return new ResultBean(ResultCode.SUCCESS, dayDuty);
    }
}
