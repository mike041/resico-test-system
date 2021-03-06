package cn.resico.test.mapper;

import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.vo.interfcace.InterfaceQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InterfaceQueryMapper {
    List<InterfaceDTO> selectList(InterfaceQuery query);
}
