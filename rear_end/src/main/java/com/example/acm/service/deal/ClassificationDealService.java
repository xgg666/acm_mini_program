package com.example.acm.service.deal;

import com.example.acm.common.ResultBean;
import com.example.acm.entity.Classification;
import com.example.acm.entity.User;

import javax.annotation.Resource;

/**
 * Created by xgg on 2019/1/10.
 */
public interface ClassificationDealService {

    public ResultBean addClassify(User user, String name);

    public ResultBean selectClass(User user, String className, int aOrs, String order, int pageNum, int pageSize);

    public ResultBean deleteClass(User user, long classId);
}
