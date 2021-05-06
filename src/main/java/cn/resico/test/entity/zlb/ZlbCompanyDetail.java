package cn.resico.test.entity.zlb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 企业信息补充
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public class ZlbCompanyDetail implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long uid;

    private Long companyId;

    /**
     * 企业管理员名称
     */
    private String adminName;

    /**
     * 企业管理员身份证号
     */
    private String adminCardNumber;

    /**
     * 企业管理员手机号
     */
    private String adminMobile;

    /**
     * 法人名称
     */
    private String legalName;

    /**
     * 法人身份证号
     */
    private String legalCardNumber;

    /**
     * 对公账户银行名称
     */
    private String bankName;

    /**
     * 对公账户银行号
     */
    private String bankCardNumber;

    /**
     * 对公账户支行
     */
    private String bankDetailName;

    /**
     * 证件正面图片id地址
     */
    private Long cardFrontImg;

    /**
     * 证件背面图片id地址
     */
    private Long cardBackImg;

    /**
     * 活体采集图片id地址
     */
    private Long validationImg;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 更新人
     */
    private Long updatedBy;

    /**
     * 版本号
     */
    private Integer version;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminCardNumber() {
        return adminCardNumber;
    }

    public void setAdminCardNumber(String adminCardNumber) {
        this.adminCardNumber = adminCardNumber;
    }

    public String getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalCardNumber() {
        return legalCardNumber;
    }

    public void setLegalCardNumber(String legalCardNumber) {
        this.legalCardNumber = legalCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankDetailName() {
        return bankDetailName;
    }

    public void setBankDetailName(String bankDetailName) {
        this.bankDetailName = bankDetailName;
    }

    public Long getCardFrontImg() {
        return cardFrontImg;
    }

    public void setCardFrontImg(Long cardFrontImg) {
        this.cardFrontImg = cardFrontImg;
    }

    public Long getCardBackImg() {
        return cardBackImg;
    }

    public void setCardBackImg(Long cardBackImg) {
        this.cardBackImg = cardBackImg;
    }

    public Long getValidationImg() {
        return validationImg;
    }

    public void setValidationImg(Long validationImg) {
        this.validationImg = validationImg;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "ZlbCompanyDetail{" +
        "id=" + id +
        ", uid=" + uid +
        ", companyId=" + companyId +
        ", adminName=" + adminName +
        ", adminCardNumber=" + adminCardNumber +
        ", adminMobile=" + adminMobile +
        ", legalName=" + legalName +
        ", legalCardNumber=" + legalCardNumber +
        ", bankName=" + bankName +
        ", bankCardNumber=" + bankCardNumber +
        ", bankDetailName=" + bankDetailName +
        ", cardFrontImg=" + cardFrontImg +
        ", cardBackImg=" + cardBackImg +
        ", validationImg=" + validationImg +
        ", createdAt=" + createdAt +
        ", createdBy=" + createdBy +
        ", updatedAt=" + updatedAt +
        ", updatedBy=" + updatedBy +
        ", version=" + version +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
