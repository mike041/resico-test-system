package cn.resico.test.service;

import cn.resico.test.pojo.Interface;

import java.util.List;


public interface InterfaceService {
    //添加一个接口
    boolean addInterface(Interface i);

    //修改一个接口
    boolean updateInterface(Interface i);

    //删除一个接口
    boolean deleteInterface(long id);

    //查询所有接口

    List<Interface> queryInterface();

    //通过名称查询接口
    List<Interface> queryInterfaceByName(String name);
}
