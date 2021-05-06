package cn.resico.test.entity.zlb;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 企业信息详情
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public class ZlbCompany implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

    /**
     * 用户编号
     */
    private Long uid;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司原始名称
     */
    private String companyOriginName;

    /**
     * 统一信用代码
     */
    private String companyCode;

    /**
     * 营业执照图片id
     */
    private Long businessLicense;

    /**
     * 省名称
     */
    private Integer province;

    /**
     * 市名称
     */
    private Integer city;

    /**
     * 区名称
     */
    private Integer area;

    /**
     * 公司详细地址
     */
    private String address;

    /**
     * 认证状态 0：待验证 1：成功 2：失败 3认证中
     */
    private Integer status;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 认证步骤
     */
    private Boolean verifyStep;

    /**
     * 备注
     */
    private String remark;

    /**
     * 隐藏任务 1隐藏 0展示
     */
    private Boolean isShowTask;

    /**
     * 认证时间
     */
    private LocalDateTime authAt;

    /**
     * 完善信息时间
     */
    private LocalDateTime confirmAt;

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
     * 是否展示api发布的任务（0-不展示 1-展示）
     */
    private Boolean isShowApiTask;

    /**
     * api任务能否通过平台报名 0-不能 1-能
     */
    private Boolean apiCanFromPlatform;

    /**
     * 是否是开放平台用户
     */
    @TableField("isOpenPlatformUser")
    private Boolean isopenplatformuser;

    /**
     * 该企业用户能使用的收款方式，	银行卡  支付宝  微信	3个二进制位	例子：3个都有：111=7
     */
    private Integer personPayWay;


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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyOriginName() {
        return companyOriginName;
    }

    public void setCompanyOriginName(String companyOriginName) {
        this.companyOriginName = companyOriginName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Long getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(Long businessLicense) {
        this.businessLicense = businessLicense;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getVerifyStep() {
        return verifyStep;
    }

    public void setVerifyStep(Boolean verifyStep) {
        this.verifyStep = verifyStep;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsShowTask() {
        return isShowTask;
    }

    public void setIsShowTask(Boolean isShowTask) {
        this.isShowTask = isShowTask;
    }

    public LocalDateTime getAuthAt() {
        return authAt;
    }

    public void setAuthAt(LocalDateTime authAt) {
        this.authAt = authAt;
    }

    public LocalDateTime getConfirmAt() {
        return confirmAt;
    }

    public void setConfirmAt(LocalDateTime confirmAt) {
        this.confirmAt = confirmAt;
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

    public Boolean getIsShowApiTask() {
        return isShowApiTask;
    }

    public void setIsShowApiTask(Boolean isShowApiTask) {
        this.isShowApiTask = isShowApiTask;
    }

    public Boolean getApiCanFromPlatform() {
        return apiCanFromPlatform;
    }

    public void setApiCanFromPlatform(Boolean apiCanFromPlatform) {
        this.apiCanFromPlatform = apiCanFromPlatform;
    }

    public Boolean getIsopenplatformuser() {
        return isopenplatformuser;
    }

    public void setIsopenplatformuser(Boolean isopenplatformuser) {
        this.isopenplatformuser = isopenplatformuser;
    }

    public Integer getPersonPayWay() {
        return personPayWay;
    }

    public void setPersonPayWay(Integer personPayWay) {
        this.personPayWay = personPayWay;
    }

    @Override
    public String toString() {
        return "ZlbCompany{" +
        "id=" + id +
        ", uid=" + uid +
        ", companyName=" + companyName +
        ", companyOriginName=" + companyOriginName +
        ", companyCode=" + companyCode +
        ", businessLicense=" + businessLicense +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", address=" + address +
        ", status=" + status +
        ", reason=" + reason +
        ", verifyStep=" + verifyStep +
        ", remark=" + remark +
        ", isShowTask=" + isShowTask +
        ", authAt=" + authAt +
        ", confirmAt=" + confirmAt +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        ", deleteFlag=" + deleteFlag +
        ", version=" + version +
        ", isShowApiTask=" + isShowApiTask +
        ", apiCanFromPlatform=" + apiCanFromPlatform +
        ", isopenplatformuser=" + isopenplatformuser +
        ", personPayWay=" + personPayWay +
        "}";
    }
}
