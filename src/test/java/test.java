
import cn.resico.test.entity.Interface;
import cn.resico.test.mapper.InterfaceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
public class test {

    @Autowired
    InterfaceMapper interfaceMapper;

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
}
