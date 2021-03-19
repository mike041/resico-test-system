package cn.resico.test.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class InterfaceInstanceDTO {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("bash_path")
    private String bashPath;

    @TableField("testcase_id")
    @ApiModelProperty("测试用例id")
    private Integer testcaseId;

    @TableField("testcase_name")
    @ApiModelProperty("测试用例名称")
    private String testcaseName;

    @TableField("interface_id")
    @ApiModelProperty("接口id")
    private Integer interfaceId;

    @TableField("interface_name")
    @ApiModelProperty("接口名称")
    private String interfaceName;

    @TableField("is_execute")
    @ApiModelProperty("是否执行 1执行 2不执行")
    private Integer isExecute;

    @TableField("request_type")
    @ApiModelProperty("请求类型")
    private String requestType;

    @TableField("interface_url")
    @ApiModelProperty("接口路径")
    private String interfaceUrl;

    @TableField("instance_data")
    private String instanceData;
    @TableField("save_result")
    private String saveResult;
    @TableField("verification_type")
    private Integer verificationType;
    @TableField("verification_context")
    private String verificationContext;
    @TableField("interface_instance_result")
    private String interfaceInstanceResult;
    private Integer sort;
    @TableField("interface_data")
    private String interfaceData;


}
