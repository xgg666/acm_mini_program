package com.example.acm.service.deal;

import com.example.acm.common.ResultBean;
import com.example.acm.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by xgg on 2019/1/19.
 */
@Service
public interface NewsDealService {

    ResultBean addNews(User user, String newsTitle, String newsBody, int isPublic, String classType);

    ResultBean updateNews(User user, long newsId, String newsTitle, String newsBody, int isPublic, String classType);

    ResultBean deleteNews(User user, long newsId);

    ResultBean detail(User user, long newsId);

    ResultBean selectNews(String newsTitle, int aOrs, String order, int pageNum, int pageSize,int isPublic);
}
