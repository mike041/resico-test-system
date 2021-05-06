package cn.resico.test.mapper.zlb;

import cn.resico.test.entity.zlb.ZlbUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 账户表 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-04-19
 */
public interface ZlbUsersMapper extends BaseMapper<ZlbUsers> {

    @Insert("<script>" + "INSERT INTO `zlb`.`zlb_users`( `type`, `nickname`, `mobile`, `auth`, `password`, `parent_uid`, `status`, `gravatar`, `source`, `isverify`, `verify_at`, `invitee_uid`, `is_api`, `islock`, `forbidden_reason`, `last_login_at`, `last_login_ip`, `last_login_address`, `created_at`, `updated_at`, `deleted_at`, `version`, `created_by`, `updated_by`, `delete_flag`, `note`, `sst_file_id`, `salt`) VALUES ( 2, #{nickname}, #{mobile}, NULL, '2eaace68f61258db7c27a2b8a72f202b', 0, 1, NULL, 1, 1, NULL, NULL, 0, 0, NULL, '2021-04-19 10:09:26', '10.233.70.0', '', '2021-03-29 14:21:08', '2021-03-29 14:21:08', NULL, NULL, 0, 0, 0, NULL, NULL, '57a-');" + "</script>")
    void myInsertUser(@Param("nickname") String nickname,
                      @Param("mobile") String mobile);
}
