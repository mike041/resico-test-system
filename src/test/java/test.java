

import cn.resico.test.dto.InterfaceInstanceDTO;
import cn.resico.test.entity.Interface;
import cn.resico.test.mapper.InterfaceMapper;
import cn.resico.test.service.InterfaceService;
import cn.resico.test.service.TestcaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.text.Collator;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;


@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
@Slf4j
public class test extends AbstractTestNGSpringContextTests {

    @Autowired
    private InterfaceMapper interfaceMapper;
    @Autowired
    private InterfaceService interfaceService;
    @Autowired
    private TestcaseService testcaseService;

    @BeforeClass
    public void before() {


    }

    @AfterClass
    public void after() {
        log.error("Slf4j的日志");
    }


    @Test
    public void test() {
        List<Interface> interfaceList = interfaceMapper.selectByMap(null);
        interfaceList.forEach(System.out::println);
    }

    @Test
    public void testByMap() {
        Map<String, Object> map = new HashMap();
        map.put("name", "接口3");
        List<Interface> interfaceList = interfaceMapper.selectByMap(map);
        interfaceList.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        Page<Interface> page = new Page<>(2, 5);
        interfaceMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);

    }

    @Test
    public void testWrapper() {
        QueryWrapper<Interface> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("request_type")
                .isNotNull("data");

        List<Interface> interfaceList = interfaceMapper.selectList(wrapper);
        System.out.println("----------------------------------------------");
        interfaceList.forEach(System.out::println);
    }

    @Test
    public void testService() {
        Interface i = interfaceMapper.selectById(1);
        System.out.println("testService:" + i);
        i.setName("xin1");
        interfaceService.updateInterface(i);
    }


    @DataProvider(name = "testcase")
    public Iterator<Object[]> dataProvider() {
        List<Object[]> list = new ArrayList<>();
        List<InterfaceInstanceDTO> interfaceInstanceDTOList = interfaceService.queryInterfaceInstanceById(1);
        for (InterfaceInstanceDTO interfaceInstanceDTO : interfaceInstanceDTOList) {
            InterfaceInstanceDTO[] objects = new InterfaceInstanceDTO[]{interfaceInstanceDTO};
            list.add(objects);
        }
        return list.iterator();
    }

    @Test(timeOut = 100,groups = "ss",enabled = true,description = "描述")
    public void test100() throws NoSuchMethodException {

        Method method = this.getClass().getMethod("test100");
        method.isAnnotationPresent(Test.class);


        Test annotation = method.getAnnotation(Test.class);
        long l = annotation.timeOut();
        String[] groups = annotation.groups();
        boolean enabled = annotation.enabled();
        String description = annotation.description();




    }

    class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
