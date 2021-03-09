import cn.resico.test.controller.InterfaceController;
import cn.resico.test.controller.TestcaseController;
import cn.resico.test.entity.InterfaceInstance;
import cn.resico.test.entity.Testcase;
import cn.resico.test.mapper.TestcaseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
public class TestTestcase {

    @Autowired
    InterfaceController controller;
    @Autowired
    TestcaseController testcaseController;
    @Autowired
    TestcaseMapper testcaseMapper;

    @Test
    public void test() {
        InterfaceInstance interfaceInstance = new InterfaceInstance();
        String data = "{\"name\":\"哈哈\"}";
        interfaceInstance.setInterfaceId(1);
        interfaceInstance.setTestcaseId(1);
        interfaceInstance.setData(data);
        interfaceInstance.setVerificationType(1);
        interfaceInstance.setSort(1);
        interfaceInstance.setIsExecute(1);

        Testcase testcase = testcaseMapper.selectById(1);
        testcase.setName("测试用例新");


//        controller.addInstance(interfaceInstance);
        testcaseController.delete(1);

    }
}
