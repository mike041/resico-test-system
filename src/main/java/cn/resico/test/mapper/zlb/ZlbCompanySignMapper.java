package cn.resico.test.mapper.zlb;

import cn.resico.test.entity.zlb.ZlbCompanySign;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 企业标识表 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-04-20
 */
public interface ZlbCompanySignMapper extends BaseMapper<ZlbCompanySign> {
    String sql = "INSERT INTO `zlb`.`zlb_company_sign`(`id`, `uid`, `aes_key`, `offset`, `sign`, `created_at`, `updated_at`, `version`, `created_by`, `updated_by`, `delete_flag`) VALUES (#{id}, #{uid}, #{aes_key}, #{offset},#{sign}, '2021-01-04 11:56:53', '2021-01-04 11:56:53', NULL, 0, 0, 0);";

    @Insert("<script>" + sql + "</script>")
    void myInsert(@Param("id") long id,
                  @Param("uid") long uid,
                  @Param("aes_key") String aes_key,
                  @Param("offset") String offset,
                  @Param("sign") String sign
    );
}
