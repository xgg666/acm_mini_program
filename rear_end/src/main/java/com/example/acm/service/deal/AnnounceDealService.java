package com.example.acm.service.deal;

import com.example.acm.common.ResultBean;
import com.example.acm.entity.User;

/**
 * Created by xgg on 2019/1/13.
 */
public interface AnnounceDealService {

    public ResultBean addAnnounce(User user, String announceTitle, String announceBody, int isPublic);

    public ResultBean updateAnnounce(User user, long announceId, String announceTitle, String announceBody, int isPublic);

    public ResultBean selectAnnounce(String announceTitle, int aOrs, String order, int pageNum, int pageSize);

    public ResultBean deleteAnnounce(User user, long announceId);

    public ResultBean detail(User user, long announceId);

    public ResultBean updateFirst(User user, long announceId);
}
