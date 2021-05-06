import cn.resico.test.common.utils.Excel;
import cn.resico.test.entity.Testcase;
import cn.resico.test.entity.TestcaseDetail;
import cn.resico.test.mapper.InterfaceMapper;
import cn.resico.test.mapper.TestcaseDetailMapper;
import cn.resico.test.service.TestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
public class TestExcel extends AbstractTestNGSpringContextTests {

    @Autowired
    TestcaseService testcaseService;
    @Autowired
    TestcaseDetailMapper testcaseDetailMapper;
    @Autowired
    InterfaceMapper interfaceMapper;

    @Test(description = "将excel里的用例存到数据库中")
    public void test() {
        Excel excel = new Excel("F:\\测试文档\\测试用例.xlsx");
        List<Map<String, String>> all = excel.getAllDataMap();
        for (int i = 0; i < all.size(); i++) {
            Map<String, String> map = all.get(i);
            Testcase testcase = new Testcase();
            TestcaseDetail testcaseDetail = new TestcaseDetail();
            testcase.setName(map.get("name"));
            testcaseService.addTestcase(testcase);
            testcaseDetail.setTestcaseId(testcase.getId());
            testcaseDetail.setData(map.get("data"));
            testcaseDetail.setInterfaceId(Integer.valueOf(map.get("interface_id")));
            testcaseDetail.setVerificationType(Integer.valueOf(map.get("verification_type")));
            testcaseDetail.setVerificationContext(map.get("verification_context"));
            testcaseDetail.setIsExecute(Integer.valueOf(map.get("is_execute")));
            testcaseService.addTestcaseDetail(testcaseDetail);
            System.out.println(testcaseDetail);
        }
    }



    @Test
    public void addUrl() {
        List<TestcaseDetail> testcaseDetails = testcaseDetailMapper.selectList(null);
        for (TestcaseDetail testcaseDetail : testcaseDetails) {
            String url = interfaceMapper.selectById(testcaseDetail.getInterfaceId()).getUrl();
            String basePath = interfaceMapper.selectById(testcaseDetail.getInterfaceId()).getBasePath();
            testcaseDetail.setUrl(basePath + url);
            testcaseDetailMapper.updateById(testcaseDetail);
        }

    }
}
