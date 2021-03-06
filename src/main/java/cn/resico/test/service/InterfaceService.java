package cn.resico.test.service;

import cn.resico.test.entity.Interface;
import cn.resico.test.vo.interfcace.InterfaceQuery;

import java.util.List;


public interface InterfaceService {

    //添加一个接口
    int addInterface(Interface i);

    //修改一个接口
    int updateInterface(Interface i);

    //删除一个接口
    int deleteInterface(Integer id);

    //批量删除接口
    int deleteInterfaceByIds(List<Integer> ids);


    //通过id查询
    Interface queryInterfaceById(Integer id);

    //通过ids查询
    List<Interface> queryInterfaceByIds(List<Integer> ids);

    //查询接口
    List<Interface> query(InterfaceQuery query);
}
