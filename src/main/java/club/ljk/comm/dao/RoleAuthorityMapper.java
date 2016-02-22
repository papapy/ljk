package club.ljk.comm.dao;

import club.ljk.comm.dao.base.BaseMapper;
import club.ljk.comm.model.RoleAuthority;
import org.apache.ibatis.annotations.Insert;

public interface RoleAuthorityMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xkey_role_authority
     *
     * @mbggenerated
     */
    @Insert({
        "insert into xkey_role_authority (role, authority)",
        "values (#{role,jdbcType=VARCHAR}, #{authority,jdbcType=VARCHAR})"
    })
    int insert(RoleAuthority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xkey_role_authority
     *
     * @mbggenerated
     */
    int insertSelective(RoleAuthority record);
}