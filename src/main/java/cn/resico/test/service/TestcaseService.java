package cn.resico.test.service;

import cn.resico.test.entity.Testcase;
import cn.resico.test.vo.interfcace.TestcaseQuery;

import java.util.List;


public interface TestcaseService {

    int addTestcase(Testcase i);

    int updateTestcase(Testcase i);

    int deleteTestcase(Integer id);

    int deleteTestcaseByIds(List<Integer> ids);


    Testcase queryTestcaseById(Integer id);

    List<Testcase> queryTestcaseByIds(List<Integer> ids);


    List<Testcase> query(TestcaseQuery query);

}
