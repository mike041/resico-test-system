package cn.resico.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyt
 * @since 2021-03-02
 */
@TableName("testcase_interface_relation")
public class TestcaseInterfaceRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 接口id
     */
    @TableField("interface_id")
    private Integer interfaceId;
    /**
     * 接口带参数id
     */
    @TableField("interface_with_params_id")
    private Integer interfaceWithParamsId;
    /**
     * 用例id
     */
    @TableField("testcase_id")
    private Integer testcaseId;
    /**
     * 校验内容
     */
    private Integer sort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Integer getInterfaceWithParamsId() {
        return interfaceWithParamsId;
    }

    public void setInterfaceWithParamsId(Integer interfaceWithParamsId) {
        this.interfaceWithParamsId = interfaceWithParamsId;
    }

    public Integer getTestcaseId() {
        return testcaseId;
    }

    public void setTestcaseId(Integer testcaseId) {
        this.testcaseId = testcaseId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "TestcaseInterfaceRelation{" +
        ", id=" + id +
        ", interfaceId=" + interfaceId +
        ", interfaceWithParamsId=" + interfaceWithParamsId +
        ", testcaseId=" + testcaseId +
        ", sort=" + sort +
        "}";
    }
}
