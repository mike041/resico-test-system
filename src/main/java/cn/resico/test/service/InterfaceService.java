package cn.resico.test.service;

import cn.resico.test.entity.Condition;
import cn.resico.test.entity.Interface;

import java.util.HashMap;
import java.util.List;


public interface InterfaceService {
    //添加一个接口
    int addInterface(Interface i);

    //修改一个接口
    int updateInterface(Interface i);

    //删除一个接口
    int deleteInterface(long id);

    //查询所有接口

    List<Interface> queryInterface();

    Interface queryInterfaceById(int id);
    //通过名称查询接口
    List<Interface> queryInterfaceByName(String name);
}
