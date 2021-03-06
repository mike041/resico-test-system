package cn.resico.test.service.impl;

import cn.resico.test.mapper.InterfaceGroupMapper;
import cn.resico.test.entity.InterfaceGroup;
import cn.resico.test.service.InterfaceGroupService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InterfaceGroupServiceImpl implements InterfaceGroupService {

    @Autowired
    private InterfaceGroupMapper interfaceGroupMapper;


    @Override
    public int addGroup(InterfaceGroup i) {
        return interfaceGroupMapper.insert(i);
    }

    @Override
    public int updateGroup(InterfaceGroup i) {
        return interfaceGroupMapper.updateById(i);
    }

    @Override
    public int deleteGroup(long id) {
        return interfaceGroupMapper.deleteById(id);
    }

    @Override
    public int deleteGroupByIds(List<Integer> ids) {
        return interfaceGroupMapper.deleteBatchIds(ids);
    }

    @Override
    public InterfaceGroup queryGroupById(Integer id) {
        return interfaceGroupMapper.selectById(id);
    }

    @Override
    public List<InterfaceGroup> queryGroupByIds(List<Integer> ids) {
        return interfaceGroupMapper.selectBatchIds(ids);

    }

    @Override
    public List<InterfaceGroup> query(Map<String, Object> map) {
        QueryWrapper<InterfaceGroup> wrapper = new QueryWrapper();
        if (map.containsKey("name")) {
            wrapper.like("name", map.get("name"));
        }
        if (map.containsKey("description")) {
            wrapper.like("description", map.get("description"));
        }
        return interfaceGroupMapper.selectList(wrapper);
    }
}
