package cn.resico.test.controller;

import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.entity.Interface;
import cn.resico.test.entity.InterfaceInstance;
import cn.resico.test.service.InterfaceService;
import cn.resico.test.vo.interfcace.InterfaceQuery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Transactional
@RequestMapping("/interface")
@AllArgsConstructor
public class InterfaceController {

    /*controller 调用service*/
    @Autowired
    private InterfaceService interfaceService;

    /**
     * 跳转接口列表页
     *
     * @param
     * @param model
     * @return
     */

    @RequestMapping("/listPage")
    public String interfaceList(InterfaceQuery query, Model model) {
        List<InterfaceDTO> interfaceList = interfaceService.query(query);
        model.addAttribute("interfaceList", interfaceList);
        return "allInterface";
    }

    /**
     * 跳转新增接口页
     *
     * @return
     */
    @RequestMapping("/addPage")
    public String toAdd() {
        return "addInterface";
    }

    /**
     * 跳转更新接口页
     *
     * @param id    接口id
     * @param model 视图模型
     * @return
     */
    @RequestMapping("/updatePage")
    public String toUpdate(int id, Model model) {
        Interface i = interfaceService.queryInterfaceById(id);
        model.addAttribute("interface", i);
        return "updateInterface";
    }


    @RequestMapping("/add")
    public String addInterface(Interface i) {
        System.out.println(i);
        interfaceService.addInterface(i);
        return "redirect: /interface/listPage";
    }


    @RequestMapping("/delete/{id}")
    public String deleteInterface(@PathVariable("id") int id) {
        interfaceService.deleteInterface(id);
        return "redirect: /interface/listPage";
    }


    @RequestMapping("/update")
    public String updateInterface(Interface i) {
        System.out.println("controller:" + i.getData());
        interfaceService.updateInterface(i);
        return "redirect: /interface/listPage";
    }


    @RequestMapping("/instance/add")
    public String addInstance(InterfaceInstance i) {
        interfaceService.addInstance(i);
        return "redirect: /interface/listPage";
    }


    @RequestMapping("/delete/instance/{id}")
    public String deleteInstance(@PathVariable("id") int id) {
        interfaceService.deleteInstance(id);
        return "redirect: /interface/listPage";
    }


    @RequestMapping("/update/instance")
    public String updateInstance(InterfaceInstance i) {
        interfaceService.updateInstance(i);
        return "redirect: /interface/listPage";
    }


}
