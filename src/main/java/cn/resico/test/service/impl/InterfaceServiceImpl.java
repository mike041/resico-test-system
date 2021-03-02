package cn.resico.test.service.impl;

import cn.resico.test.mapper.InterfaceMapper;
import cn.resico.test.entity.Condition;
import cn.resico.test.entity.Interface;
import cn.resico.test.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("interfaceServiceImpl")
public class InterfaceServiceImpl implements InterfaceService {

    //service层 调用dao层
    @Autowired
    private InterfaceMapper interfaceMapper;


    @Override
    public int addInterface(Interface i) {
        return interfaceMapper.insert(i);
    }

    @Override
    public int updateInterface(Interface i) {
        System.out.println("InterfaceServiceImpl:Interface" + i);
        return interfaceMapper.updateById(i);
    }

    @Override
    public int deleteInterface(long id) {
        return interfaceMapper.deleteById(id);
    }

    @Override
    public List<Interface> queryInterface() {
        return interfaceMapper.selectByMap(null);
    }

    @Override
    public Interface queryInterfaceById(int id) {
        return interfaceMapper.selectById(id);
    }

    @Override
    public List<Interface> queryInterfaceByName(String name) {
        Map<String, Object> map = new HashMap();
        map.put("name", name);
        return interfaceMapper.selectByMap(map);
    }
}
