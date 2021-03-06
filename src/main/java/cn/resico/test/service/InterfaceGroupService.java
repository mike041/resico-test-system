package cn.resico.test.service;

import cn.resico.test.entity.InterfaceGroup;

import java.util.List;
import java.util.Map;


public interface InterfaceGroupService {
    int addGroup(InterfaceGroup i);

    int updateGroup(InterfaceGroup i);

    int deleteGroup(long id);

    int deleteGroupByIds(List<Integer> ids);

    InterfaceGroup queryGroupById(Integer id);

    List<InterfaceGroup> queryGroupByIds(List<Integer> ids);

    List<InterfaceGroup> query(Map<String, Object> map);
}
