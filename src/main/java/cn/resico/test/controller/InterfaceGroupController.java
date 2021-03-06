package cn.resico.test.controller;

import cn.resico.test.entity.InterfaceGroup;
import cn.resico.test.service.InterfaceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class InterfaceGroupController {
    /*controller 调用service*/
    @Autowired
    InterfaceGroupService interfaceGroupService;

    @RequestMapping("/add")
    public String addInterface(InterfaceGroup i) {
        interfaceGroupService.addGroup(i);
        return null;
    }


    @RequestMapping("/delete/{id}")
    public String deleteInterface(@PathVariable("id") int id) {
        interfaceGroupService.deleteGroup(id);
        return "redirect: /interface/allInterface";
    }


    @RequestMapping("/update")
    public String updateInterface(InterfaceGroup i) {
        interfaceGroupService.updateGroup(i);
        return "redirect: /interface/allInterface";
    }

}
