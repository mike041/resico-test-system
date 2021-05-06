package cn.resico.test.mapper.zlb;

import cn.resico.test.entity.zlb.ZlbCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 企业信息详情 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public interface ZlbCompanyMapper extends BaseMapper<ZlbCompany> {

    @Insert("<script>" + "INSERT INTO `zlb`.`zlb_company`( `id`, `uid`, `company_name`, `company_origin_name`, `company_code`, `business_license`, `province`, `city`, `area`, `address`, `status`, `reason`, `verify_step`, `remark`, `is_show_task`, `auth_at`, `confirm_at`, `created_at`, `updated_at`, `created_by`, `updated_by`, `delete_flag`, `version`, `is_show_api_task`, `api_can_from_platform`, `isOpenPlatformUser`, `person_pay_way`) VALUES (#{id}, #{uid}, #{company_name}, #{company_name}, #{company_code}, 1376427461471182849, NULL, NULL, NULL, NULL, 1, '', 1, NULL, 0, '2021-03-29 14:34:06', NULL, '2021-03-29 14:32:51', '2021-03-29 14:54:14', 0, 0, 0, NULL, 0, 0, 0, 7);"+ "</script>")
    void myInsert(@Param("id") long id,@Param("uid") long uid, @Param("company_name") String company_name, @Param("company_code") String company_code);

}
