package cn.resico.test.service.impl;

import cn.resico.test.dao.InterfaceMapper;
import cn.resico.test.pojo.Condition;
import cn.resico.test.pojo.Interface;
import cn.resico.test.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("interfaceServiceImpl")
public class InterfaceServiceImpl implements InterfaceService {

    //service层 调用dao层
    @Autowired
    private InterfaceMapper interfaceMapper;


    @Override
    public int addInterface(Interface i) {
        return interfaceMapper.addInterface(i);
    }

    @Override
    public int updateInterface(Interface i) {
        System.out.println("InterfaceServiceImpl:Interface" + i);
        return interfaceMapper.updateInterface(i);
    }

    @Override
    public int deleteInterface(long id) {
        return interfaceMapper.deleteInterface(id);
    }

    @Override
    public List<Interface> queryInterface() {
        return interfaceMapper.queryInterface();
    }

    @Override
    public Interface queryInterfaceById(int id) {
        return interfaceMapper.queryInterfaceById(id);
    }

    @Override
    public List<Interface> queryInterfaceByName(String name) {
        return interfaceMapper.queryInterfaceByName(name);
    }

    @Override
    public List<Interface> queryLimit(HashMap<String, Integer> map) {
        HashMap<String, Integer> defaultMap = new HashMap();
        final int startIndex = 0;
        final int page = 5;
        defaultMap.put("startIndex", startIndex);
        defaultMap.put("page", page);
        if (map.isEmpty()) {
            map.putAll(defaultMap);
        }
        return interfaceMapper.queryLimit(map);

    }

    @Override
    public List<Interface> query(Condition condition) {
        return interfaceMapper.query(condition);
    }
}
