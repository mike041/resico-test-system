package cn.resico.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyt
 * @since 2021-03-02
 */
@TableName("interface_hisotry")
public class InterfaceHisotry implements Serializable {

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
    private String requestType;
    /**
     * 角色ID
     */
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
    private String headers;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "InterfaceHisotry{" +
        ", id=" + id +
        ", interfaceId=" + interfaceId +
        ", name=" + name +
        ", requestType=" + requestType +
        ", protocolType=" + protocolType +
        ", data=" + data +
        ", url=" + url +
        ", params=" + params +
        ", headers=" + headers +
        ", status=" + status +
        ", groupId=" + groupId +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        "}";
    }
}
