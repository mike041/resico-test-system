package cn.resico.test.mapper;

import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.entity.Interface;
import cn.resico.test.vo.interfcace.InterfaceQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InterfaceMapper extends BaseMapper<Interface> {
    List<InterfaceDTO> selectList(InterfaceQuery query);
}
