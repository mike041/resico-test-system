package cn.resico.test.controller.interfaceAuto;

import cn.resico.test.service.ExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/execute")
public class executeController {

    @Autowired
    ExecuteService executeService;

    @RequestMapping("executeCase")
    public String execute(List<Integer> list) {
        executeService.execute(list);
        return "succeed";
    }

}
