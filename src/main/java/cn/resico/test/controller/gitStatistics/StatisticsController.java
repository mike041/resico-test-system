package cn.resico.test.controller.gitStatistics;

import cn.resico.test.entity.gitStatistics.User;
import cn.resico.test.service.gitStatistics.StatisticsService;
import cn.resico.test.vo.gitStatistics.GitQuery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@RequestMapping("/gitStatistic")
@Controller
@Transactional
@AllArgsConstructor
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @RequestMapping("/statistic")
    public String statistic(GitQuery query, Model model) throws Exception {
        List<User> statistics = statisticsService.statistic(query);
        System.out.println("--------------!!!!!");
        model.addAttribute("statistics", statistics);
        return "statisticPage";
    }


}
