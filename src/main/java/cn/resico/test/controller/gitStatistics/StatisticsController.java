package cn.resico.test.controller.gitStatistics;

import cn.resico.test.entity.gitStatistics.StatisticsUser;
import cn.resico.test.service.gitStatistics.StatisticsService;
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
    public String statistic(String start, String end, Model model) throws Exception {
        List<StatisticsUser> statistics = statisticsService.statistic(start, end);
        model.addAttribute("statistics", statistics);
        return "statisticsPage";
    }

    @RequestMapping("/statisticPage")
    public String statisticPage() {
        return "statisticsPage";
    }


}
