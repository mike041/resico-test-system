package cn.resico.test.entity.zlb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 账户表
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public class ZlbUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户分类 1 个人 2 企业
     */
    private Integer type;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 令牌（api个人注册使用）
     */
    private String auth;

    /**
     * 加密后密码串
     */
    private String password;

    /**
     * 主账号id
     */
    private Long parentUid;

    /**
     * 账号状态 1正常 0禁用
     */
    private Boolean status;

    /**
     * 头像文件id
     */
    private Long gravatar;

    /**
     * 用户来源 0未知 1pc 2小程序 3后台添加
     */
    private Boolean source;

    /**
     * 认证状态 1已认证 0未认证
     */
    private Integer isverify;

    /**
     * 认证成功时间
     */
    private LocalDateTime verifyAt;

    /**
     * 邀请人用户id
     */
    private Long inviteeUid;

    /**
     * 是否为api注册（1-是 0-否）
     */
    private Boolean isApi;

    /**
     * 锁定状态 1锁定 0正常
     */
    private Boolean islock;

    /**
     * 禁用原因
     */
    private String forbiddenReason;

    /**
     * 最近一次登入时间
     */
    private LocalDateTime lastLoginAt;

    /**
     * 最近一次登录ip
     */
    private String lastLoginIp;

    /**
     * 最近一次登录ip的归属地
     */
    private String lastLoginAddress;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 账号删除时间
     */
    private LocalDateTime deletedAt;

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

    /**
     * 备注
     */
    private String note;

    /**
     * 税税通图片id
     */
    private Long sstFileId;

    /**
     * 随机码
     */
    private String salt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getParentUid() {
        return parentUid;
    }

    public void setParentUid(Long parentUid) {
        this.parentUid = parentUid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getGravatar() {
        return gravatar;
    }

    public void setGravatar(Long gravatar) {
        this.gravatar = gravatar;
    }

    public Boolean getSource() {
        return source;
    }

    public void setSource(Boolean source) {
        this.source = source;
    }

    public Integer getIsverify() {
        return isverify;
    }

    public void setIsverify(Integer isverify) {
        this.isverify = isverify;
    }

    public LocalDateTime getVerifyAt() {
        return verifyAt;
    }

    public void setVerifyAt(LocalDateTime verifyAt) {
        this.verifyAt = verifyAt;
    }

    public Long getInviteeUid() {
        return inviteeUid;
    }

    public void setInviteeUid(Long inviteeUid) {
        this.inviteeUid = inviteeUid;
    }

    public Boolean getIsApi() {
        return isApi;
    }

    public void setIsApi(Boolean isApi) {
        this.isApi = isApi;
    }

    public Boolean getIslock() {
        return islock;
    }

    public void setIslock(Boolean islock) {
        this.islock = islock;
    }

    public String getForbiddenReason() {
        return forbiddenReason;
    }

    public void setForbiddenReason(String forbiddenReason) {
        this.forbiddenReason = forbiddenReason;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(LocalDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginAddress() {
        return lastLoginAddress;
    }

    public void setLastLoginAddress(String lastLoginAddress) {
        this.lastLoginAddress = lastLoginAddress;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getSstFileId() {
        return sstFileId;
    }

    public void setSstFileId(Long sstFileId) {
        this.sstFileId = sstFileId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "ZlbUsers{" +
        "id=" + id +
        ", type=" + type +
        ", nickname=" + nickname +
        ", mobile=" + mobile +
        ", auth=" + auth +
        ", password=" + password +
        ", parentUid=" + parentUid +
        ", status=" + status +
        ", gravatar=" + gravatar +
        ", source=" + source +
        ", isverify=" + isverify +
        ", verifyAt=" + verifyAt +
        ", inviteeUid=" + inviteeUid +
        ", isApi=" + isApi +
        ", islock=" + islock +
        ", forbiddenReason=" + forbiddenReason +
        ", lastLoginAt=" + lastLoginAt +
        ", lastLoginIp=" + lastLoginIp +
        ", lastLoginAddress=" + lastLoginAddress +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", deletedAt=" + deletedAt +
        ", version=" + version +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        ", deleteFlag=" + deleteFlag +
        ", note=" + note +
        ", sstFileId=" + sstFileId +
        ", salt=" + salt +
        "}";
    }
}
