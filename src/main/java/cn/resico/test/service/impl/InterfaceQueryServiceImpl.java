package cn.resico.test.service.impl;

import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.entity.Interface;
import cn.resico.test.mapper.InterfaceQueryMapper;
import cn.resico.test.service.InterfaceQueryService;
import cn.resico.test.vo.interfcace.InterfaceQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InterfaceQueryServiceImpl implements InterfaceQueryService {

    @Autowired
    InterfaceQueryMapper interfaceQueryMapper;


    @Override
    public InterfaceDTO queryInterfaceById(Integer id) {
        return null;
    }

    @Override
    public List<InterfaceDTO> queryInterfaceByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<InterfaceDTO> query(InterfaceQuery query) {

        return interfaceQueryMapper.selectList(query);
    }
}
