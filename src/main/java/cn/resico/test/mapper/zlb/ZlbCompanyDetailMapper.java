package cn.resico.test.mapper.zlb;

import cn.resico.test.entity.zlb.ZlbCompanyDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 企业信息补充 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public interface ZlbCompanyDetailMapper extends BaseMapper<ZlbCompanyDetail> {

    @Insert("INSERT INTO `zlb`.`zlb_company_detail`(`id`, `uid`, `company_id`, `admin_name`, `admin_card_number`, `admin_mobile`, `legal_name`, `legal_card_number`, `bank_name`, `bank_card_number`, `bank_detail_name`, `card_front_img`, `card_back_img`, `validation_img`, `created_at`, `created_by`, `updated_at`, `updated_by`, `version`, `delete_flag`) VALUES (#{id}, #{uid}, #{company_id}, #{admin_name}, '500105199504015852', '15902379217', '周云腾', '500105199504015852', NULL, NULL, NULL, 1376427465845841922, 1376427470690263042, 1376427473525612546, '2021-03-29 14:34:16', 0, '2021-03-29 14:54:17', 0, NULL, 0);")
    void myInsert(@Param("id") long id, @Param("uid") long uid, @Param("company_id") long company_id, @Param("admin_name") String admin_name);

}
