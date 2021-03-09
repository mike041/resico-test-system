package cn.resico.test.controller;

import cn.resico.test.dto.InterfaceInstanceDTO;
import cn.resico.test.entity.Testcase;
import cn.resico.test.service.InterfaceService;
import cn.resico.test.service.TestcaseService;
import cn.resico.test.vo.interfcace.TestcaseQuery;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/testcase")
@AllArgsConstructor
public class TestcaseController {

    /*controller 调用service*/
    @Autowired
    private TestcaseService testcaseService;
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
    public String testcaseList(TestcaseQuery query, Model model) {
        List<Testcase> testcaseList = testcaseService.query(query);
        model.addAttribute("testcaseList", testcaseList);
        return "allTestcasePage";
    }


    /**
     * 跳转新增接口页
     *
     * @return
     */
    @RequestMapping("/addPage")
    public String toAdd() {
        return "addTestcase";
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
        Testcase testcase = testcaseService.queryTestcaseById(id);
        model.addAttribute("testcase", testcase);
        return "updateTestcase";
    }


    @RequestMapping("/add")
    public String add(Testcase testcase) {
        testcaseService.addTestcase(testcase);
        return "redirect: /testcase/listPage";
    }


    @ApiOperation("删除用例")
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        testcaseService.deleteTestcase(id);
        return "redirect: /testcase/listPage";
    }

    @ApiOperation("新增用例")
    @RequestMapping("/update")
    public String update(Testcase testcase) {
        testcaseService.updateTestcase(testcase);
        return "redirect: /testcase/listPage";
    }

    @ApiOperation("查询测试用例详情")
    @RequestMapping("/{id}")
    public String testcaseDetail(@PathVariable("id") Integer testcaseId, Model model) {
        List<InterfaceInstanceDTO> interfaceInstanceDTOList = interfaceService.queryInterfaceInstanceById(testcaseId);
        model.addAttribute("interfaceInstanceDTOList", interfaceInstanceDTOList);
        model.addAttribute("testcaseId", testcaseId);
        return "testcaseDetailPage";
    }



    @RequestMapping("/{id}/interfaceInstancePage")
    public String InterfaceInstancePage(@PathVariable("id") Integer testcaseId, Model model) {
        model.addAttribute("testcaseId", testcaseId);
        return "interfaceInstancePage";
    }


}
