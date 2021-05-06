package cn.resico.test.mapper.zlb;

import cn.resico.test.entity.zlb.ZlbCompanyBankAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 企业银行账号余额信息表 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public interface ZlbCompanyBankAccountMapper extends BaseMapper<ZlbCompanyBankAccount> {

    @Insert("<script>"+
            "INSERT INTO `zlb`.`zlb_company_bank_account`(`id`, `uid`, `no`, `account_no`, `account_name`, `account_deposit`, `park_id`, `balance`, `occupied_balance`, `frozen_balance`, `created_at`, `updated_at`, `created_by`, `updated_by`, `delete_flag`, `version`) VALUES (#{id}, #{uid}, 1, #{account_no}, '前端数据支持测试江西讫酉有限公司', '平安银行重庆两江支行', 1, 8000000.0000, NULL, 0.0000, '2021-03-29 15:09:56', '2021-03-29 15:09:56', 1305320785377931265, 1305320785377931265, 0, NULL);"
            +"</script>"
    )
    void  myInsert(@Param("id") long id, @Param("uid") long uid,@Param("account_no") long account_no);
}
