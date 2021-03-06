package cn.resico.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.net.httpserver.Headers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zyt
 * @since 2021-03-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("interface_history")
public class InterfaceHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 接口ID
     */
    @TableField("interface_id")
    private Integer interfaceId;
    /**
     * 用户ID
     */
    private String name;
    /**
     * 角色ID
     */
    @TableField("request_type")
    private String requestType;
    /**
     * 角色ID
     */
    @TableField("protocol_type")
    private String protocolType;
    /**
     * 角色ID
     */
    private String data;
    /**
     * 角色ID
     */
    private String url;
    private String params;
    private List<Headers> headers;
    /**
     * 1.可用  2.不可用 3.废弃
     */
    private Integer status;
    @TableField("group_id")
    private Integer groupId;
    @TableField("created_at")
    private Date createdAt;
    @TableField("updated_at")
    private Date updatedAt;
    @TableField("created_by")
    private Long createdBy;
    @TableField("updated_by")
    private Long updatedBy;

}
