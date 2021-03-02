package cn.resico.test.service;

import cn.resico.test.entity.Condition;
import cn.resico.test.entity.InterfaceGroup;

import java.util.HashMap;
import java.util.List;


public interface InterfaceGroupService {
    int addGroup(InterfaceGroup i);

    int updateGroup(InterfaceGroup i);

    int deleteGroup(long id);

    List<InterfaceGroup> queryGroup();

    InterfaceGroup queryGroupById(int id);

    List<InterfaceGroup> queryGroupByName(String name);

    List<InterfaceGroup> queryLimit(HashMap<String, Integer> hashMap);

    List<InterfaceGroup> query(Condition condition);
}
