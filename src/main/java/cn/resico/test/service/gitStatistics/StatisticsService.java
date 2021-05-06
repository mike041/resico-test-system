package cn.resico.test.service.gitStatistics;


import cn.resico.test.entity.gitStatistics.StatisticsUser;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.gitlab4j.api.GitLabApiException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface StatisticsService {
    List<StatisticsUser> statistic(String start, String end) throws Exception;

    void queryResult(String start, String end) throws Exception;

    void queryResult(String userName, String start, String end) throws ParseException, UnirestException, IOException, GitLabApiException;


}
