
import cn.resico.test.entity.Interface;
import cn.resico.test.mapper.InterfaceMapper;
import cn.resico.test.service.InterfaceService;
import cn.resico.test.service.impl.InterfaceServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
public class test {

    @Autowired
    private InterfaceMapper interfaceMapper;
    @Autowired
    private InterfaceService interfaceService;

    @Before
    public void before() {


        if (Thread.currentThread().getStackTrace()[1].getClassName().equals("test")) {
            interfaceMapper = mock(InterfaceMapper.class);
            when(interfaceMapper.insert(isA(Interface.class))).thenReturn(2);
            interfaceService = new InterfaceServiceImpl();
        }
    }

    @After
    public void after() {

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

    @Test
    public void test1() {
        System.out.println("interfaceMapper:" + interfaceMapper);


    }
}
