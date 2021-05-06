package cn.resico.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SaveResult {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "testcase_detail_id")
    private Integer testcaseDetailId;
    @TableField("key")
    private String key;
    @TableField("jsonPath")
    private String jsonPath;
}
