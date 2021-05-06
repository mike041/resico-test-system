package cn.resico.test.entity.zlb;

import java.io.Serializable;

/**
 * <p>
 * 场景税目绑定表
 * </p>
 *
 * @author zyt
 * @since 2021-04-20
 */
public class ZlbTradeTaxItem implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long tradeId;

    private Long taxItemId;


    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getTaxItemId() {
        return taxItemId;
    }

    public void setTaxItemId(Long taxItemId) {
        this.taxItemId = taxItemId;
    }

    @Override
    public String toString() {
        return "ZlbTradeTaxItem{" +
        "tradeId=" + tradeId +
        ", taxItemId=" + taxItemId +
        "}";
    }
}
