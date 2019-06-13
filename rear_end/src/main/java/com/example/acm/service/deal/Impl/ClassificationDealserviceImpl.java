package com.example.acm.service.deal.Impl;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.controller.userController;
import com.example.acm.entity.Classification;
import com.example.acm.entity.User;
import com.example.acm.service.ClassificationService;
import com.example.acm.service.deal.ClassificationDealService;
import com.example.acm.utils.DateUtils;
import com.example.acm.utils.ListPage;
import com.example.acm.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xgg on 2019/1/10.
 */
@Service
public class ClassificationDealserviceImpl implements ClassificationDealService {

    private static final Logger LOG = LoggerFactory.getLogger(ClassificationDealserviceImpl.class);
    @Autowired
    public ClassificationService classificationService;

    public ResultBean addClassify(User user, String name){
        try {
            if (StringUtils.isNull(name)) {
                return new ResultBean(ResultCode.PARAM_ERROR, "目录名不能为空");
            }
            if (name.length()>20) {
                return new ResultBean(ResultCode.PARAM_ERROR, "目录名长度不超过20");
            }
            Map<String, Object> mapSearch = new HashMap<>();
            mapSearch.put("className", name);
            mapSearch.put("isEffective", 1);
            List<Classification> list = classificationService.findClassificationListByQuery(mapSearch);
            if (list.size()!=0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "该分类已存在");
            }
            Classification classification = new Classification();
            classification.setClassName(name);
            classification.setCreateBy(user.getUserId().longValue());
            classification.setIsEffective(1);
            classification.setCreateTime(new Date());
            classification.setUpdateTime(new Date());

            classificationService.addClassification(classification);
            return new ResultBean(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean selectClass(User user, String className, int aOrs, String order, int pageNum, int pageSize){
        try {
            Map<String, Object> map = new HashMap<>();
            if (pageNum < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "页码不能小于0");
            }
            if (pageSize < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "一页展示数量不能小于0");
            }
            int start = (pageNum - 1) * pageSize;
            int limit = pageSize;
            map.put("className", className);
            map.put("start", start);
            map.put("limit", limit);
            map.put("order", order);
            if (aOrs == 1) {
                map.put("aOrS", "DESC");
            } else {
                map.put("aOrS", "ASC");
            }
            map.put("isEffective", 1);
            List<Map<String, Object>> list = classificationService.findClassificationMapListByQuery(map);

            if (list.size() >0) {
                for (Map<String, Object> mapTemp : list) {
                    mapTemp.put("createTime", DateUtils.convDateToStr((Date) mapTemp.get("createTime"), "yyyy/MM/dd HH:mm:ss"));
                    mapTemp.put("updateTime", DateUtils.convDateToStr((Date) mapTemp.get("updateTime"), "yyyy/MM/dd HH:mm:ss"));
                }
           }

            int allNum = classificationService.countClassificationListByQuery(map);

            ListPage<List<Map<String, Object>>> listPage = ListPage.createListPage(pageNum, pageSize, allNum, list);

            return new ResultBean(ResultCode.SUCCESS, listPage);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.OTHER_FAIL);
        }
    }

    public ResultBean deleteClass(User user, long classId){
        try {
            List<Classification> classifications = classificationService.findClassificationListByClassId(classId);
            if (classifications.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "该分类不存在");
            }
            Classification classification = classifications.get(0);
            if (classification.getIsEffective()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "该分类已删除");

            }
            classification.setIsEffective(0);
            classification.setUpdateTime(new Date());
            classificationService.updateClassificationByClassId(classId, classification);

            return new ResultBean(ResultCode.SUCCESS);
        } catch(Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.OTHER_FAIL);
        }
    }
}
