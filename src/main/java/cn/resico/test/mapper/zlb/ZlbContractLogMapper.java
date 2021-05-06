package cn.resico.test.mapper.zlb;

import cn.resico.test.entity.zlb.ZlbContractLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 所有协议记录表 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public interface ZlbContractLogMapper extends BaseMapper<ZlbContractLog> {
    String sql1 = "INSERT INTO `zlb`.`zlb_contract_log`(`id`, `no`, `contract_id`, `contract_name`, `uid`, `first_party`, `second_party`, `person_scale`, `company_scale`, `status`, `effective_status`, `reject_reason`, `failure_reason`, `fdd_contract_id`, `task_id`, `entry_id`, `delivery_id`, `contract_url`, `contract_down_url`, `jump_url`, `trans_id`, `type`, `sign_at`, `created_at`, `updated_at`, `created_by`, `updated_by`, `delete_flag`, `version`, `created_name`, `turnover`, `remark`, `source`, `content`, `contract_file_id`) VALUES (#{id}, #{no}, 14, '补充协议', #{uid}, #{company_name}, '海南众乐邦网络科技有限公司', 2.00, 5.00, 4, 2, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2021-03-29 15:12:59', '2021-03-29 15:12:49', '2021-03-29 15:12:49', 1305320785377931265, NULL, 0, NULL, '周云腾', 0.00, NULL, 1, '空协议', NULL);";
    String sql2 = "INSERT INTO `zlb`.`zlb_contract_log`(`id`, `no`, `contract_id`, `contract_name`, `uid`, `first_party`, `second_party`, `person_scale`, `company_scale`, `status`, `effective_status`, `reject_reason`, `failure_reason`, `fdd_contract_id`, `task_id`, `entry_id`, `delivery_id`, `contract_url`, `contract_down_url`, `jump_url`, `trans_id`, `type`, `sign_at`, `created_at`, `updated_at`, `created_by`, `updated_by`, `delete_flag`, `version`, `created_name`, `turnover`, `remark`, `source`, `content`, `contract_file_id`) VALUES (#{id}, #{no}, 3, '用工企业服务协议', #{uid}, #{company_name}, '海南众乐邦网络科技有限公司', 0.00, 0.00, 4, 2, NULL, NULL, 'ef23a1be7fd0557f65a5bddda46536ce', 0, NULL, NULL, '', '', '', '858cdd276d6c2ad35d18928eefd25c2d', 2, '2021-03-29 15:10:53', '2021-03-29 15:10:11', '2021-03-29 15:10:53', 0, 0, 0, NULL, '通山高博工程技术服务中心', 0.00, NULL, 1, NULL, NULL);";

    String sql3 = "SELECT a.no FROM  zlb_contract_log a JOIN zlb_contract b on  a.contract_id=b.id WHERE\n" +
            "b.`code`=\"supplement_service\"\n" +
            "ORDER BY  a.no desc LIMIT 1;";

    @Insert("<script>" + sql1
            + "</script>"
    )
    void myInsertSupplement(@Param("id") long id, @Param("no") String no, @Param("uid") long uid, @Param("company_name") String company_name);

    @Insert("<script>" + sql2
            + "</script>"
    )
    void myInsertEmployment(@Param("id") long id, @Param("no") String no, @Param("uid") long uid, @Param("company_name") String company_name);


    @Select("<script>" + sql3
            + "</script>"
    )
    String getNo(@Param("code") String code);

}
