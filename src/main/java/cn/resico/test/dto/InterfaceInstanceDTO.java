package cn.resico.test.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class InterfaceInstanceDTO {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("interface_id")
    private Integer interfaceId;
    @TableField("testcase_id")
    private Integer testcaseId;
    @TableField("is_execute")
    private Integer isExecute;
    @TableField("instance_data")
    private String instanceData;
    @TableField("verification_type")
    private Integer verificationType;
    @TableField("verification_context")
    private String verificationContext;
    @TableField("interface_instance_result")
    private String interfaceInstanceResult;
    private Integer sort;
    @TableField("testcase_name")
    private String testcaseName;
    @TableField("interface_data")
    private String interfaceData;
    @TableField("interface_name")
    private String interfaceName;
    @TableField("interface_url")
    private String interfaceUrl;

}
