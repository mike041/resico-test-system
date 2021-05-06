package cn.resico.test.entity.zlb;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 企业银行账号余额信息表
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public class ZlbCompanyBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long uid;

    /**
     * 卡序号 第几张卡
     */
    private Integer no;

    /**
     * 虚拟账号
     */
    private String accountNo;

    /**
     * 虚拟账户名称
     */
    private String accountName;

    /**
     * 虚拟账户开户行地址
     */
    private String accountDeposit;

    /**
     * 园区id
     */
    private Long parkId;

    /**
     * 可用余额 单位分
     */
    private BigDecimal balance;

    /**
     * 占用余额  单位分
     */
    private BigDecimal occupiedBalance;

    /**
     * 冻结余额 单位分
     */
    private BigDecimal frozenBalance;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 更新人
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

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(String accountDeposit) {
        this.accountDeposit = accountDeposit;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(BigDecimal frozenBalance) {
        this.frozenBalance = frozenBalance;
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
        return "ZlbCompanyBankAccount{" +
        "id=" + id +
        ", uid=" + uid +
        ", no=" + no +
        ", accountNo=" + accountNo +
        ", accountName=" + accountName +
        ", accountDeposit=" + accountDeposit +
        ", parkId=" + parkId +
        ", balance=" + balance +
        ", frozenBalance=" + frozenBalance +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        ", deleteFlag=" + deleteFlag +
        ", version=" + version +
        "}";
    }
}
