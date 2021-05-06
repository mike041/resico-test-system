package cn.resico.test.mapper.zlb;

import cn.resico.test.entity.zlb.ZlbCompanyTrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 企业适用场景（行业）表 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public interface ZlbCompanyTradeMapper extends BaseMapper<ZlbCompanyTrade> {

    @Insert("INSERT INTO `zlb`.`zlb_company_trade`(`id`, `uid`, `trade_id`) VALUES (#{id}, #{uid}, #{trade_id});")
    void myInsert(@Param("id") long id, @Param("uid") long uid, @Param("trade_id") long trade_id);
}
