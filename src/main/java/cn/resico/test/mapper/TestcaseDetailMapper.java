package cn.resico.test.mapper;

import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.entity.Interface;
import cn.resico.test.entity.TestcaseDetail;
import cn.resico.test.vo.interfcace.InterfaceQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestcaseDetailMapper extends BaseMapper<TestcaseDetail> {
}
