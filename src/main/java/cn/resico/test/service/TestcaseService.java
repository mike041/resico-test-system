package cn.resico.test.service;

import cn.resico.test.dto.TestcaseDetailDTO;
import cn.resico.test.entity.Testcase;
import cn.resico.test.entity.TestcaseDetail;

import java.util.List;


public interface TestcaseService {

    /**
     * 新增用例
     *
     * @param i
     * @return
     */
    int addTestcase(Testcase i);

    /**
     * 更新用例
     *
     * @param i
     * @return
     */
    int updateTestcase(Testcase i);

    /**
     * 查询用例
     *
     * @param testcaseId
     * @return
     */
    Testcase queryTestcaseById(Integer testcaseId);

    /**
     * 通过testcaseId查询用例详情
     *
     * @param testcaseId
     * @return
     */
    TestcaseDetailDTO queryTestcaseDetail(Integer testcaseId);


    /**
     * 按用例名称模糊查询
     *
     * @param name
     * @return
     */
    List<Testcase> query(String name);


    /**
     * 新增用例明细
     *
     * @param detail
     * @return
     */
    int addTestcaseDetail(TestcaseDetail detail);

    /**
     * 查询所有用例
     *
     * @return
     */
    List<Testcase> queryAll();

}
