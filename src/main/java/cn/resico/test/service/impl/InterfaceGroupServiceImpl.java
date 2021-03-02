package cn.resico.test.service.impl;

import cn.resico.test.mapper.InterfaceGroupMapper;
import cn.resico.test.entity.Condition;
import cn.resico.test.entity.InterfaceGroup;
import cn.resico.test.service.InterfaceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InterfaceGroupServiceImpl implements InterfaceGroupService {

    @Autowired
    private InterfaceGroupMapper interfaceGroupMapper;

    @Override
    public int addGroup(InterfaceGroup i) {
        return 0;
    }

    @Override
    public int updateGroup(InterfaceGroup i) {
        return 0;
    }

    @Override
    public int deleteGroup(long id) {
        return 0;
    }

    @Override
    public List<InterfaceGroup> queryGroup() {
        return interfaceGroupMapper.selectByMap(null);
    }

    @Override
    public InterfaceGroup queryGroupById(int id) {
        return null;
    }

    @Override
    public List<InterfaceGroup> queryGroupByName(String name) {
        return null;
    }

    @Override
    public List<InterfaceGroup> queryLimit(HashMap<String, Integer> hashMap) {
        return null;
    }

    @Override
    public List<InterfaceGroup> query(Condition condition) {
        return null;
    }
}
