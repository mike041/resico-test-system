package cn.resico.test.entity.zlb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 众乐邦企业对应优税猫crm信息表
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public class ZlbCompanyCrm implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

    private Long uid;

    private Long companyId;

    /**
     * 客户编码
     */
    private String code;

    /**
     * 税务销售顾问uid
     */
    private Long adviserId;

    /**
     * 税务销售顾问
     */
    private String adviser;

    /**
     * 机构
     */
    private Long organizationId;

    /**
     * 机构名
     */
    private String organizationName;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 渠道价格
     */
    private BigDecimal channelPrice;

    /**
     * 优税猫渠道id
     */
    private Long ysmTradeId;

    /**
     * 优税猫渠道路径
     */
    private String ysmTradePath;

    /**
     * 员工
     */
    private String employeeNum;

    /**
     * 经营地址
     */
    private String businessAddress;

    /**
     * 经营场所照片ids
     */
    private String businessPhotos;

    /**
     * 资质照片ids
     */
    private String qualificationPhotos;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(Long adviserId) {
        this.adviserId = adviserId;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BigDecimal getChannelPrice() {
        return channelPrice;
    }

    public void setChannelPrice(BigDecimal channelPrice) {
        this.channelPrice = channelPrice;
    }

    public Long getYsmTradeId() {
        return ysmTradeId;
    }

    public void setYsmTradeId(Long ysmTradeId) {
        this.ysmTradeId = ysmTradeId;
    }

    public String getYsmTradePath() {
        return ysmTradePath;
    }

    public void setYsmTradePath(String ysmTradePath) {
        this.ysmTradePath = ysmTradePath;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessPhotos() {
        return businessPhotos;
    }

    public void setBusinessPhotos(String businessPhotos) {
        this.businessPhotos = businessPhotos;
    }

    public String getQualificationPhotos() {
        return qualificationPhotos;
    }

    public void setQualificationPhotos(String qualificationPhotos) {
        this.qualificationPhotos = qualificationPhotos;
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

    @Override
    public String toString() {
        return "ZlbCompanyCrm{" +
        "id=" + id +
        ", uid=" + uid +
        ", companyId=" + companyId +
        ", code=" + code +
        ", adviserId=" + adviserId +
        ", adviser=" + adviser +
        ", organizationId=" + organizationId +
        ", organizationName=" + organizationName +
        ", channel=" + channel +
        ", channelPrice=" + channelPrice +
        ", ysmTradeId=" + ysmTradeId +
        ", ysmTradePath=" + ysmTradePath +
        ", employeeNum=" + employeeNum +
        ", businessAddress=" + businessAddress +
        ", businessPhotos=" + businessPhotos +
        ", qualificationPhotos=" + qualificationPhotos +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        ", deleteFlag=" + deleteFlag +
        ", version=" + version +
        "}";
    }
}
