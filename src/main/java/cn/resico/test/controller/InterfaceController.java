package cn.resico.test.controller;

import cn.resico.test.pojo.Interface;
import cn.resico.test.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/interface")
public class InterfaceController {

    /*controller 调用service*/
    @Autowired
    @Qualifier("interfaceServiceImpl")
    private InterfaceService interfaceService;


    @RequestMapping("/allInterFace")
    public String list(Model model) {
        List<Interface> interfaceList = interfaceService.queryInterface();
        ModelAndView mav = new ModelAndView("allBook");
        mav.addObject("list", interfaceList);
        for (Interface i:interfaceList
             ) {
            System.out.println(i);

        }
        return "allBook";
    }

}
