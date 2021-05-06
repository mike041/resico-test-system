package cn.resico.test.service.impl;

import cn.resico.test.dto.TestcaseDetailDTO;
import cn.resico.test.entity.Testcase;
import cn.resico.test.entity.TestcaseDetail;
import cn.resico.test.mapper.TestcaseDetailMapper;
import cn.resico.test.mapper.TestcaseMapper;
import cn.resico.test.service.TestcaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("testcaseServiceImpl")
public class TestcaseServiceImpl implements TestcaseService {

    //service层 调用dao层
    @Autowired
    private TestcaseMapper testcaseMapper;
    @Autowired
    TestcaseDetailMapper testcaseDetailMapper;


    @Override
    public int addTestcase(Testcase testcase) {
        return testcaseMapper.insert(testcase);
    }

    @Override
    public int updateTestcase(Testcase testcase) {
        return testcaseMapper.updateById(testcase);
    }

    @Override
    public Testcase queryTestcaseById(Integer testcaseId) {
        return testcaseMapper.selectById(testcaseId);
    }

    @Override
    public TestcaseDetailDTO queryTestcaseDetail(Integer testcaseId) {
        return testcaseMapper.selectDetail(testcaseId);
    }

    @Override
    public List<Testcase> query(String name) {
        QueryWrapper wrapper = new QueryWrapper<Testcase>();
        wrapper.like("name", name);
        return testcaseMapper.selectList(wrapper);
    }

    @Override
    public int addTestcaseDetail(TestcaseDetail detail) {
        return testcaseDetailMapper.insert(detail);
    }

    @Override
    public List<Testcase> queryAll() {
        return testcaseMapper.selectList(null);
    }


}
