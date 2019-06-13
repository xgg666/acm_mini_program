package com.example.acm.service.deal.Impl;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.common.SysConst;
import com.example.acm.entity.ApplyCompetition;
import com.example.acm.entity.Competition;
import com.example.acm.entity.User;
import com.example.acm.service.ApplyCompetitionService;
import com.example.acm.service.CompetitionService;
import com.example.acm.service.UserService;
import com.example.acm.service.deal.CompetitionDealService;
import com.example.acm.utils.DateUtils;
import com.example.acm.utils.ListPage;
import com.example.acm.utils.UUIDUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
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
 * Created by xgg on 2019/2/18.
 */
@Service
public class CompetitionDealImpl implements CompetitionDealService{

    private static final Logger LOG = LoggerFactory.getLogger(CompetitionDealImpl.class);

    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplyCompetitionService applyCompetitionService;

    public ResultBean addCompetition(User user, String competitionTitle, String competitionBody, String competitionBeginTime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Long bigInteger = new Long(UUIDUtil.getNumUUID());
            Date now = new Date();
            Competition competition = new Competition();
            competition.setCompetitionId(bigInteger);
            competition.setCompetitionTitle(competitionTitle);
            competition.setCompetitionBody(competitionBody);
            competition.setCreateUser(user.getUserId());
            competition.setCreateDate(sdf.parse(competitionBeginTime));
            competition.setUpdateUser(user.getUserId());
            competition.setUpdateDate(now);
            competition.setIsEffective(SysConst.LIVE);

            competitionService.addCompetition(competition);
            return new ResultBean(ResultCode.SUCCESS, bigInteger);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean detailCompetition(User user, long competitionId) {
        try {
            List<Map<String, Object>> competitions = competitionService.findCompetition2MapListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            Map<String, Object> competition = competitions.get(0);
            if ((int)competition.get("isEffective")==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            competition.put("createDate", DateUtils.convDateToStr((Date) competition.get("createDate"), "yyyy-MM-dd HH:mm:ss"));
            competition.put("updateDate", DateUtils.convDateToStr((Date) competition.get("updateDate"), "yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("competitionId", competitionId);
            map.put("isEffective", SysConst.LIVE);
            List<ApplyCompetition> applyCompetitions = applyCompetitionService.findApplyCompetitionListByQuery(map);
            competition.put("joinUserNum", applyCompetitions.size());
            return new ResultBean(ResultCode.SUCCESS, competition);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }
    public ResultBean updateCompetition(User user, long competitionId, String competitionTitle, String competitionBody, String competitionBeginTime){
        try {
            List<Competition> competitions = competitionService.findCompetitionListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            Competition competition = competitions.get(0);
            if (competition.getIsEffective()==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            competition.setCompetitionTitle(competitionTitle);
            competition.setCompetitionBody(competitionBody);
            competition.setUpdateDate(new Date());
            competition.setUpdateUser(user.getUserId());
            competition.setCreateDate(sdf.parse(competitionBeginTime));
            competitionService.updateCompetitionByCompetitionId(competitionId, competition);

            return new ResultBean(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean selectCompetition(String competitionTitle, int aOrs, String order, int pageNum, int pageSize){
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
            map.put("competitionTitle", competitionTitle);
            map.put("start", start);
            map.put("limit", limit);
            map.put("order", order);
            if (aOrs == 1) {
                map.put("aOrS", "DESC");
            } else {
                map.put("aOrS", "ASC");
            }
            map.put("isEffective", SysConst.LIVE);
            List<Map<String, Object>> list = competitionService.findCompetitionMapListByQuery(map);

            if (list.size() >0) {
                for (Map<String, Object> mapTemp : list) {
                    mapTemp.put("createDate", DateUtils.convDateToStr((Date) mapTemp.get("createDate"), "yyyy-MM-dd HH:mm:ss"));
                    mapTemp.put("updateDate", DateUtils.convDateToStr((Date) mapTemp.get("updateDate"), "yyyy-MM-dd HH:mm:ss"));
                    List<User> users = userService.findUserListByUserId(Integer.parseInt(mapTemp.get("createUser").toString()));
                    mapTemp.put("createUser", users.get(0).getUsername());;
                    List<User> users1 = userService.findUserListByUserId(Integer.parseInt(mapTemp.get("updateUser").toString()));
                    mapTemp.put("updateUser", users1.get(0).getUsername());;
                }
            }

            int allNum = competitionService.countCompetitionMapListByQuery(map);

            ListPage<List<Map<String, Object>>> listPage = ListPage.createListPage(pageNum, pageSize, allNum, list);

            return new ResultBean(ResultCode.SUCCESS, listPage);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean deleteCompetition(User user, long competitionId){
        try{
            List<Competition> competitions = competitionService.findCompetitionListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在校赛");
            }
            Competition competition = competitions.get(0);
            if (competition.getIsEffective()==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            competition.setIsEffective(SysConst.NOT_LIVE);
            competition.setUpdateDate(new Date());
            competition.setUpdateUser(user.getUserId());
            competitionService.updateCompetitionByCompetitionId(competitionId, competition);

            return new ResultBean(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean doneCompetition(User user, long competitionId, int mean){
        try{
            List<Competition> competitions = competitionService.findCompetitionListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在校赛");
            }
            Competition competition = competitions.get(0);
            if (competition.getIsEffective()==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            competition.setUpdateDate(new Date());
            competition.setUpdateUser(user.getUserId());
            competition.setIsDone(mean);
            competitionService.updateCompetitionByCompetitionId(competitionId, competition);

            return new ResultBean(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean joinCompetition(User user, long competitionId){
        try{
            List<Competition> competitions = competitionService.findCompetitionListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在校赛");
            }
            Competition competition = competitions.get(0);
            if (competition.getIsEffective()==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            if (competition.getIsDone()==0) {
                    return new ResultBean(ResultCode.PARAM_ERROR, "该比赛已结束");
                }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("competitionId", competitionId);
            map.put("joinUser", user.getUserId());
            map.put("isEffective", SysConst.LIVE);
            List<ApplyCompetition> applyCompetitions = applyCompetitionService.findApplyCompetitionListByQuery(map);
            if (applyCompetitions.size()!=0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "您已报名");
            }
            map.put("isEffective", SysConst.NOT_LIVE);
            applyCompetitions = applyCompetitionService.findApplyCompetitionListByQuery(map);
            ApplyCompetition applyCompetition = new ApplyCompetition();
            if (applyCompetitions.size() != 0) {
                if (applyCompetitions.size() != 1) {
                    return new ResultBean(ResultCode.SYSTEM_FAILED);
                }
                applyCompetition = applyCompetitions.get(0);
                applyCompetition.setIsEffective(SysConst.LIVE);
                applyCompetitionService.updateApplyCompetitionByApplyCompetitionId(applyCompetition.getApplyCompetitionId(), applyCompetition);
            } else {
                applyCompetition.setCompetitionId(competitionId);
                applyCompetition.setJoinUser(user.getUserId());
                applyCompetition.setCreateDate(new Date());
                applyCompetition.setIsEffective(SysConst.LIVE);
                applyCompetitionService.addApplyCompetition(applyCompetition);
            }

            return new ResultBean(ResultCode.SUCCESS, "报名成功");
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }


    public ResultBean quitCompetition(User user, long competitionId) {
        try{
            List<Competition> competitions = competitionService.findCompetitionListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在校赛");
            }
            Competition competition = competitions.get(0);
            if (competition.getIsEffective()==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            if (competition.getIsDone()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "该比赛已结束");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("competitionId", competitionId);
            map.put("joinUser", user.getUserId());
            map.put("isEffective", SysConst.LIVE);
            List<ApplyCompetition> applyCompetitions = applyCompetitionService.findApplyCompetitionListByQuery(map);
            if (applyCompetitions.size() != 1) {
                return new ResultBean(ResultCode.SYSTEM_FAILED);
            }
            ApplyCompetition applyCompetition = applyCompetitions.get(0);
            applyCompetition.setIsEffective(SysConst.NOT_LIVE);
            applyCompetitionService.updateApplyCompetitionByApplyCompetitionId(applyCompetition.getApplyCompetitionId(), applyCompetition);

            return new ResultBean(ResultCode.SUCCESS, "取消报名成功");
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean personCompetition(User user, long competitionId, int aOrs, String order, int pageNum, int pageSize){
        try{
            List<Competition> competitions = competitionService.findCompetitionListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在校赛");
            }
            Competition competition = competitions.get(0);
            if (competition.getIsEffective()==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }

            Map<String, Object> map = new HashMap<>();
            if (pageNum < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "页码不能小于0");
            }
            if (pageSize < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "一页展示数量不能小于0");
            }
            int start = (pageNum - 1) * pageSize;
            int limit = pageSize;
            map.put("competitionId", competitionId);
            map.put("start", start);
            map.put("limit", limit);
            map.put("order", order);
            if (aOrs == 1) {
                map.put("aOrS", "DESC");
            } else {
                map.put("aOrS", "ASC");
            }
            map.put("isEffective", 1);
            List<Map<String, Object>> list = userService.findUserByCompetitionId(map);
            if (list.size() >0) {
                for (Map<String, Object> mapTemp : list) {
                    mapTemp.put("createDate", DateUtils.convDateToStr((Date) mapTemp.get("createDate"), "yyyy-MM-dd HH:mm:ss"));
                    }
            }

            int allNum = userService.countUserByCompetitionId(map);

            ListPage<List<Map<String, Object>>> listPage = ListPage.createListPage(pageNum, pageSize, allNum, list);
            return new ResultBean(ResultCode.SUCCESS, listPage);
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean userCompetition(User user, int userId, int aOrs, String order, int pageNum, int pageSize){
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
            map.put("joinUser", userId);
            if (userId==-1) {
                map.put("joinUser", user.getUserId());
            }
            map.put("isEffective", SysConst.LIVE);
            List<Map<String, Object>> list1 = competitionService.findCompetitionMapListByUser(map);
            int allNum = list1.size();
            map.put("start", start);
            map.put("limit", limit);
            map.put("order", order);
            if (aOrs == 1) {
                map.put("aOrS", "DESC");
            } else {
                map.put("aOrS", "ASC");
            }
            List<Map<String, Object>> list = competitionService.findCompetitionMapListByUser(map);

            if (list.size() >0) {
                for (Map<String, Object> mapTemp : list) {
                    mapTemp.put("createDate", DateUtils.convDateToStr((Date) mapTemp.get("createDate"), "yyyy-MM-dd HH:mm:ss"));
                    mapTemp.put("updateDate", DateUtils.convDateToStr((Date) mapTemp.get("updateDate"), "yyyy-MM-dd HH:mm:ss"));
                    List<User> users = userService.findUserListByUserId(Integer.parseInt(mapTemp.get("createUser").toString()));
                    mapTemp.put("createUser", users.get(0).getUsername());;
                    List<User> users1 = userService.findUserListByUserId(Integer.parseInt(mapTemp.get("updateUser").toString()));
                    mapTemp.put("updateUser", users1.get(0).getUsername());;
                }
            }


            ListPage<List<Map<String, Object>>> listPage = ListPage.createListPage(pageNum, pageSize, allNum, list);

            return new ResultBean(ResultCode.SUCCESS, listPage);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }
    public ResultBean detailCompetitionWithUser(User user, long competitionId) {
        try {
            List<Map<String, Object>> competitions = competitionService.findCompetition2MapListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            competitions = DateUtils.changeDateNormal(competitions, "createDate", "updateDate");
            Map<String, Object> competition = competitions.get(0);
            if ((int)competition.get("isEffective")==SysConst.NOT_PASS) {
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("competitionId", competitionId);
            map.put("isEffective", SysConst.LIVE);
            map.put("joinUser", user.getUserId());
            List<ApplyCompetition> applyCompetitions = applyCompetitionService.findApplyCompetitionListByQuery(map);
            competition.put("isJoin", applyCompetitions.size());
            return new ResultBean(ResultCode.SUCCESS, competition);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error((e.getMessage()));
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public XSSFWorkbook export(long competitionId) {
        try {
            List<Competition> competitions = competitionService.findCompetitionListByCompetitionId(competitionId);
            if (competitions.size()==0) {
                //return new ResultBean(ResultCode.PARAM_ERROR, "不存在校赛");
            }
            Competition competition = competitions.get(0);
            if (competition.getIsEffective()==SysConst.NOT_PASS) {
                //return new ResultBean(ResultCode.PARAM_ERROR, "不存在该校赛");
            }

            // 第一步：定义一个新的工作簿
            XSSFWorkbook wb = new XSSFWorkbook();
            // 第二步：创建一个Sheet页
            XSSFSheet sheet = wb.createSheet("参赛证明");


            sheet.setDefaultRowHeight((short) (2 * 256));//设置行高
            sheet.setColumnWidth(0, 4000);//设置列宽
            sheet.setColumnWidth(1,5500);
            XSSFFont font = wb.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 20);

            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setFont(font);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);

            XSSFRow row0 = sheet.createRow(0);
            XSSFCell cell0 = row0.createCell(0);
            cell0.setCellValue(competition.getCompetitionTitle());
            cell0.setCellStyle(cellStyle);



            XSSFRow row = sheet.createRow(1);
            XSSFCell cell = row.createCell(0);
            cell.setCellValue("参赛人姓名 ");
            cell = row.createCell(1);
            cell.setCellValue("参赛人学号");

            Map<String, Object> map = new HashMap<>();

            map.put("competitionId", competitionId);
            //  map.put("isPublic", isPublic);
            map.put("isEffective", 1);
            List<Map<String, Object>> list = userService.findUserByCompetitionId(map);
            XSSFRow rows;
            XSSFCell cells;
            int sum=2;
            if (list.size() >0) {
                System.out.println(list.size());
                for (Map<String, Object> mapTemp : list) {
                    System.out.println(mapTemp.get("realname"));
                    mapTemp.put("createDate", DateUtils.convDateToStr((Date) mapTemp.get("createDate"), "yyyy-MM-dd HH:mm:ss"));
                    // 第三步：在这个sheet页里创建一行
                    rows = sheet.createRow(sum++);
                    // 第四步：在该行创建一个单元格
                    cells = rows.createCell(0);
                    // 第五步：在该单元格里设置值
                    cells.setCellValue((String)mapTemp.get("realname"));

                    cells = rows.createCell(1);
                    cells.setCellValue((long)mapTemp.get("studentId"));
                }
            }

            // 合并日期占两行(4个参数，分别为起始行，结束行，起始列，结束列)
            // 行和列都是从0开始计数，且起始结束都会合并
            // 这里是合并excel中日期的两行为一行
            CellRangeAddress region = new CellRangeAddress(0, 0, 0, 1);
            sheet.addMergedRegion(region);


            return wb;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return null;
        }
    }

}
