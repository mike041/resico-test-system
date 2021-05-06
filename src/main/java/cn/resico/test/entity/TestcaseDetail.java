package cn.resico.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TestcaseDetail {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("interface_id")
    private Integer interfaceId;
    @TableField("testcase_id")
    private Integer testcaseId;
    private String url;
    @TableField("is_execute")
    private Integer isExecute;
    private String data;
    @TableField("verification_type")
    private Integer verificationType;
    @TableField("verification_context")
    private String verificationContext;
    @TableField("interface_instance_result")
    private String interfaceInstanceResult;
    private Integer sort;
    @TableField("save_result")
    private List<String> saveResult;
}
