package cn.resico.test.entity.zlb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 企业适用场景（行业）表
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public class ZlbCompanyTrade implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 行业ID（场景）
     */
    private Long tradeId;


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

    @Override
    public String toString() {
        return "ZlbCompanyTrade{" +
        "id=" + id +
        ", uid=" + uid +
        ", tradeId=" + tradeId +
        "}";
    }
}
