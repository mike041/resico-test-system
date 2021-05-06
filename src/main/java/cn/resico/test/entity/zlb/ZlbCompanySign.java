package cn.resico.test.entity.zlb;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 企业标识表
 * </p>
 *
 * @author zyt
 * @since 2021-04-20
 */
public class ZlbCompanySign implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

    /**
     * 企业用户id
     */
    private Long uid;

    /**
     * aes密钥
     */
    private String aesKey;

    /**
     * 偏移量
     */
    private String offset;

    /**
     * 企业标识
     */
    private String sign;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 修改人
     */
    private Long updatedBy;

    /**
     * 逻辑删除标记
     */
    private Integer deleteFlag;


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

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "ZlbCompanySign{" +
        "id=" + id +
        ", uid=" + uid +
        ", aesKey=" + aesKey +
        ", offset=" + offset +
        ", sign=" + sign +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", version=" + version +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
