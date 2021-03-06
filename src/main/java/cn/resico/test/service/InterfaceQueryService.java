package cn.resico.test.service;

import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.vo.interfcace.InterfaceQuery;

import java.util.List;


public interface InterfaceQueryService {




    //通过id查询
    InterfaceDTO queryInterfaceById(Integer id);

    //通过ids查询
    List<InterfaceDTO> queryInterfaceByIds(List<Integer> ids);

    //查询接口
    List<InterfaceDTO> query(InterfaceQuery query);
}
