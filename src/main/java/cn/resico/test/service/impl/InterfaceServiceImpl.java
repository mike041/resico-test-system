package cn.resico.test.service.impl;

import cn.resico.test.dao.InterfaceMapper;
import cn.resico.test.pojo.Interface;
import cn.resico.test.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("interfaceServiceImpl")
public class InterfaceServiceImpl implements InterfaceService {

    //service层 调用dao层
    @Autowired
    private InterfaceMapper interfaceMapper;


    @Override
    public boolean addInterface(Interface i) {
        return interfaceMapper.addInterface(i);
    }

    @Override
    public boolean updateInterface(Interface i) {
        return interfaceMapper.updateInterface(i);
    }

    @Override
    public boolean deleteInterface(long id) {
        return interfaceMapper.deleteInterface(id);
    }

    @Override
    public List<Interface> queryInterface() {
        return interfaceMapper.queryInterface();
    }

    @Override
    public List<Interface> queryInterfaceByName(String name) {
        return interfaceMapper.queryInterfaceByName(name);
    }
}
