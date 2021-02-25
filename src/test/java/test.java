import cn.resico.test.dao.InterfaceMapper;
import cn.resico.test.pojo.Interface;
import cn.resico.test.service.InterfaceService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        InterfaceService interfaceService = (InterfaceService) context.getBean("InterfaceServiceImpl");
        List<Interface> interfaceList = interfaceService.queryInterface();

        for (Interface i : interfaceList
        ) {
            System.out.println(i);
        }

    }


}
