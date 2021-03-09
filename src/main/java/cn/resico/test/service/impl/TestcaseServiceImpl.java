package cn.resico.test.service.impl;

import cn.resico.test.entity.InterfaceInstance;
import cn.resico.test.entity.Testcase;
import cn.resico.test.mapper.InterfaceInstanceMapper;
import cn.resico.test.mapper.TestcaseMapper;
import cn.resico.test.service.TestcaseService;
import cn.resico.test.vo.interfcace.TestcaseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service("testcaseServiceImpl")
public class TestcaseServiceImpl implements TestcaseService {

    //service层 调用dao层
    @Autowired
    private TestcaseMapper testcaseMapper;

    @Autowired
    private InterfaceInstanceMapper interfaceInstanceMapper;



    @Override
    public int addTestcase(Testcase testcase) {

        return testcaseMapper.insert(testcase);
    }

    @Override
    public int updateTestcase(Testcase testcase) {
        return testcaseMapper.updateById(testcase);
    }

    @Override
    public int deleteTestcase(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("testcase_id", id);
        List<InterfaceInstance> interfaceInstanceList = interfaceInstanceMapper.selectByMap(map);
        for (InterfaceInstance interfaceInstance :
                interfaceInstanceList) {
            interfaceInstanceMapper.deleteById(interfaceInstance.getId());
        }
        return testcaseMapper.deleteById(id);
    }

    @Override
    public int deleteTestcaseByIds(List<Integer> ids) {
        return testcaseMapper.deleteBatchIds(ids);
    }

    @Override
    public Testcase queryTestcaseById(Integer id) {
        return testcaseMapper.selectById(id);
    }

    @Override
    public List<Testcase> queryTestcaseByIds(List<Integer> ids) {
        return testcaseMapper.selectBatchIds(ids);
    }

    @Override
    public List<Testcase> query(TestcaseQuery query) {
        return testcaseMapper.select(query);
    }
}
