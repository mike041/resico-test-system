package cn.resico.test.controller;

import cn.resico.test.entity.InterfaceGroup;
import cn.resico.test.service.InterfaceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/group")
public class InterfaceGroupController {

    @Autowired
    InterfaceGroupService interfaceGroupService;

    /*int addGroup(Group i);

    int updateGroup(Group i);

    int deleteGroup(long id);


    Group queryGroupById(int id);

    List<Group> queryGroupByName(String name);

    List<Group> queryLimit(HashMap<String, Integer> hashMap);

    List<Group> query(Condition condition);*/
    @RequestMapping("/queryGroup")
    public String queryGroup(Model model) {
        List<InterfaceGroup> interfaceGroupList = interfaceGroupService.queryGroup();
        for (InterfaceGroup g: interfaceGroupList
             ) {
            System.out.println("GroupController"+g);
        }
        model.addAttribute(interfaceGroupList);
        return "allInterface";
    }

}
