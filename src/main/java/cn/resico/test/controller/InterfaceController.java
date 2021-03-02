package cn.resico.test.controller;

import cn.resico.test.entity.Condition;
import cn.resico.test.entity.Interface;
import cn.resico.test.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/interface")
public class InterfaceController {

    /*controller 调用service*/
    @Autowired
    @Qualifier("interfaceServiceImpl")
    private InterfaceService interfaceService;



    /*返回统一格式*/
   /* @RequestMapping("/allInterface")
    public String list(Model model) {
        List<Interface> interfaceList = interfaceService.queryLimit(new HashMap<>());
        Result result = new Result();
        result.code(200).message("成功").success(true).data("list", interfaceList);
        return JSON.toJSONString(result);
    }*/


    @RequestMapping("/toAddInterface")
    public String toaddInterface(Interface i) {
        return "addInterface";
    }

    @RequestMapping("/addInterface")
    public String addInterface(Interface i) {
        System.out.println(i);
        interfaceService.addInterface(i);
        return "redirect: /interface/allInterface";
    }


    @RequestMapping("/deleteInterface/{id}")
    public String deleteInterface(@PathVariable("id") int id) {
        interfaceService.deleteInterface(id);
        return "redirect: /interface/allInterface";
    }


    @RequestMapping("/toUpdateInterface")
    public String toUpdateInterface(int id, Model model) {
        Interface i = interfaceService.queryInterfaceById(id);
        model.addAttribute("interface", i);
        return "updateInterface";
    }

    @RequestMapping("/updateInterface")
    public String updateInterface(Interface i) {
        interfaceService.updateInterface(i);
        return "redirect: /interface/allInterface";
    }

    @RequestMapping("queryInterfaceByName")
    public String queryInterfaceByName(@RequestParam("name") String name, Model model) {
        List<Interface> interfaceList = interfaceService.queryInterfaceByName(name);
        model.addAttribute(interfaceList);
        return "allInterface";
    }

}
