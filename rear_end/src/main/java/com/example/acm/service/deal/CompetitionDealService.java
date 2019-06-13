package com.example.acm.service.deal;

import com.example.acm.common.ResultBean;
import com.example.acm.entity.User;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by xgg on 2019/2/18.
 */
public interface CompetitionDealService {

    ResultBean addCompetition(User user, String competitionTitle, String competitionBody, String competitionBeginTime);

    ResultBean updateCompetition(User user, long competitionId, String competitionTitle, String competitionBody, String competitionBeginTime);

    ResultBean selectCompetition(String competitionTitle, int aOrs, String order, int pageNum, int pageSize);

    ResultBean deleteCompetition(User user, long competitionId);

    ResultBean detailCompetition(User user, long competitionId);

    ResultBean joinCompetition(User user, long competitionId);

    ResultBean quitCompetition(User user, long competitionId);

    ResultBean doneCompetition(User user, long competitionId, int mean);

    ResultBean personCompetition(User user, long competitionId, int aOrs, String order, int pageNum, int pageSize);

    ResultBean userCompetition(User user, int userId, int aOrs, String order, int pageNum, int pageSize);

    ResultBean detailCompetitionWithUser(User user, long competitionId);

    XSSFWorkbook export(long competitionId);
}
