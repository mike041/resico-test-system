package cn.resico.test.entity.zlb;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 所有协议记录表
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public class ZlbContractLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 协议编号
     */
    private String no;

    /**
     * 协议id
     */
    private Long contractId;

    /**
     * 协议名称
     */
    private String contractName;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 协议甲方
     */
    private String firstParty;

    /**
     * 协议乙方
     */
    private String secondParty;

    /**
     * 个人返点比例
     */
    private BigDecimal personScale;

    /**
     * 企业返点比例
     */
    private BigDecimal companyScale;

    /**
     * 状态：1=待确认，2=已撤回，3=被驳回，4=已确认 5=待发送
     */
    private Integer status;

    /**
     * 生效状态：1=待生效，2=生效中，3=已失效
     */
    private Integer effectiveStatus;

    /**
     * 驳回原因
     */
    private String rejectReason;

    /**
     * 失效原因
     */
    private String failureReason;

    /**
     * 法大大合同id
     */
    private String fddContractId;

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 报名id
     */
    private Long entryId;

    /**
     * 交付id
     */
    private Long deliveryId;

    /**
     * 签署后合同地址
     */
    private String contractUrl;

    /**
     * 签署后合同下载地址
     */
    private String contractDownUrl;

    /**
     * 跳转地址
     */
    private String jumpUrl;

    /**
     * 交易号
     */
    private String transId;

    /**
     * 1返点协议 2法大大电子协议
     */
    private Integer type;

    /**
     * 签署时间
     */
    private LocalDateTime signAt;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 修改时间
     */
    private LocalDateTime updatedAt;

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

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建人名称
     */
    private String createdName;

    /**
     * 预估流水
     */
    private BigDecimal turnover;

    private String remark;

    /**
     * 来源：1=后台，2=优税猫
     */
    private Boolean source;

    /**
     * 持久化补充协议内容
     */
    private String content;

    /**
     * 协议文件oss文件id
     */
    private Long contractFileId;


    /**
     * 协议文件oss文件id
     */
    private int userType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }

    public BigDecimal getPersonScale() {
        return personScale;
    }

    public void setPersonScale(BigDecimal personScale) {
        this.personScale = personScale;
    }

    public BigDecimal getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(BigDecimal companyScale) {
        this.companyScale = companyScale;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEffectiveStatus() {
        return effectiveStatus;
    }

    public void setEffectiveStatus(Integer effectiveStatus) {
        this.effectiveStatus = effectiveStatus;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getFddContractId() {
        return fddContractId;
    }

    public void setFddContractId(String fddContractId) {
        this.fddContractId = fddContractId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl;
    }

    public String getContractDownUrl() {
        return contractDownUrl;
    }

    public void setContractDownUrl(String contractDownUrl) {
        this.contractDownUrl = contractDownUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getSignAt() {
        return signAt;
    }

    public void setSignAt(LocalDateTime signAt) {
        this.signAt = signAt;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getSource() {
        return source;
    }

    public void setSource(Boolean source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getContractFileId() {
        return contractFileId;
    }

    public void setContractFileId(Long contractFileId) {
        this.contractFileId = contractFileId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "ZlbContractLog{" +
                "id=" + id +
                ", no=" + no +
                ", contractId=" + contractId +
                ", contractName=" + contractName +
                ", uid=" + uid +
                ", firstParty=" + firstParty +
                ", secondParty=" + secondParty +
                ", personScale=" + personScale +
                ", companyScale=" + companyScale +
                ", status=" + status +
                ", effectiveStatus=" + effectiveStatus +
                ", rejectReason=" + rejectReason +
                ", failureReason=" + failureReason +
                ", fddContractId=" + fddContractId +
                ", taskId=" + taskId +
                ", entryId=" + entryId +
                ", deliveryId=" + deliveryId +
                ", contractUrl=" + contractUrl +
                ", contractDownUrl=" + contractDownUrl +
                ", jumpUrl=" + jumpUrl +
                ", transId=" + transId +
                ", type=" + type +
                ", signAt=" + signAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", deleteFlag=" + deleteFlag +
                ", version=" + version +
                ", createdName=" + createdName +
                ", turnover=" + turnover +
                ", remark=" + remark +
                ", source=" + source +
                ", content=" + content +
                ", contractFileId=" + contractFileId +
                "}";
    }
}
