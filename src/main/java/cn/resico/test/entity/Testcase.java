package cn.resico.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zyt
 * @since 2021-03-02
 */
@Data

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


}
