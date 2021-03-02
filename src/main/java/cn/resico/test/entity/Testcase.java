package cn.resico.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyt
 * @since 2021-03-02
 */
public class Testcase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用例名称
     */
    private String name;
    /**
     * 用例分组ID
     */
    @TableField("testcase_group_id")
    private Integer testcaseGroupId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTestcaseGroupId() {
        return testcaseGroupId;
    }

    public void setTestcaseGroupId(Integer testcaseGroupId) {
        this.testcaseGroupId = testcaseGroupId;
    }

    @Override
    public String toString() {
        return "Testcase{" +
        ", id=" + id +
        ", name=" + name +
        ", testcaseGroupId=" + testcaseGroupId +
        "}";
    }
}
