package cn.resico.test.entity.zlb;

import lombok.Builder;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 企业与场景园区交付成果绑定表
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
@Builder
public class ZlbCompanyRelation implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

    private Long uid;

    private Long tradeId;

    private Long parkId;

    /**
     * 交付成果
     */
    private String deliveryName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean deleteFlag;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 修改人
     */
    private Long updatedBy;

    /**
     * 版本号
     */
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ZlbCompanyRelation{" +
        "id=" + id +
        ", uid=" + uid +
        ", tradeId=" + tradeId +
        ", parkId=" + parkId +
        ", deliveryName=" + deliveryName +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", deleteFlag=" + deleteFlag +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        ", version=" + version +
        "}";
    }
}
