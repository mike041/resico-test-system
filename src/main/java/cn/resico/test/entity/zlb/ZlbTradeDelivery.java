package cn.resico.test.entity.zlb;

import java.io.Serializable;

/**
 * <p>
 * 场景交付成果
 * </p>
 *
 * @author zyt
 * @since 2021-04-20
 */
public class ZlbTradeDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long tradeId;

    /**
     * 交付成果名称
     */
    private String name;


    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ZlbTradeDelivery{" +
        "tradeId=" + tradeId +
        ", name=" + name +
        "}";
    }
}
