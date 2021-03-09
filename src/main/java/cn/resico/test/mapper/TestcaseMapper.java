package cn.resico.test.mapper;

import cn.resico.test.entity.Testcase;
import cn.resico.test.vo.interfcace.TestcaseQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-03-02
 */
@Repository
public interface TestcaseMapper extends BaseMapper<Testcase> {
    List<Testcase> select(TestcaseQuery query);
}
