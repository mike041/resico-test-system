package cn.resico.test.service.gitStatistics;


import cn.resico.test.entity.gitStatistics.User;
import cn.resico.test.vo.gitStatistics.GitQuery;

import java.util.List;

public interface StatisticsService {
    public List<User> statistic(GitQuery query) throws Exception;

}
