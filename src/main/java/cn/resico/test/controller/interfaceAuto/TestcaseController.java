package cn.resico.test.controller.interfaceAuto;

import cn.resico.test.entity.Testcase;
import cn.resico.test.service.InterfaceService;
import cn.resico.test.service.TestcaseService;
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

    @ApiOperation("跳转接口列表页")
    @RequestMapping("/listPage")
    public String testcaseList(String name, Model model) {
        List<Testcase> testcaseList = testcaseService.query(name);
        model.addAttribute("testcaseList", testcaseList);
        return "allTestcasePage";
    }

    @ApiOperation("跳转新增接口页")
    @RequestMapping("/addPage")
    public String toAdd() {
        return "addTestcase";
    }

    @ApiOperation("跳转更新接口页")
    @RequestMapping("/updatePage")
    public String toUpdate(int id, Model model) {
        Testcase testcase = testcaseService.queryTestcaseById(id);
        model.addAttribute("testcase", testcase);
        return "updateTestcase";
    }

    @ApiOperation("新增接口")
    @RequestMapping("/add")
    public String add(Testcase testcase) {
        testcaseService.addTestcase(testcase);
        return "redirect: /testcase/listPage";
    }

    @ApiOperation("新增用例")
    @RequestMapping("/update")
    public String update(Testcase testcase) {
        testcaseService.updateTestcase(testcase);
        return "redirect: /testcase/listPage";
    }
}
