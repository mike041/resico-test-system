package cn.resico.test.entity.zlb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 税目字典表
 * </p>
 *
 * @author zyt
 * @since 2021-04-20
 */
public class ZlbTaxItem implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 税目名称
     */
    private String taxItemName;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 1启用 0禁用
     */
    private Boolean status;

    /**
     * 排序
     */
    private Integer sort;

    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime updatedAt;

    private Long updatedBy;

    private Integer deleteFlag;

    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxItemName() {
        return taxItemName;
    }

    public void setTaxItemName(String taxItemName) {
        this.taxItemName = taxItemName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ZlbTaxItem{" +
        "id=" + id +
        ", taxItemName=" + taxItemName +
        ", parentId=" + parentId +
        ", status=" + status +
        ", sort=" + sort +
        ", createdAt=" + createdAt +
        ", createdBy=" + createdBy +
        ", updatedAt=" + updatedAt +
        ", updatedBy=" + updatedBy +
        ", deleteFlag=" + deleteFlag +
        ", version=" + version +
        "}";
    }
}
