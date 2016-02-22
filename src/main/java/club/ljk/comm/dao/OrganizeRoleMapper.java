package club.ljk.comm.dao;

import club.ljk.comm.dao.base.BaseMapper;
import club.ljk.comm.model.OrganizeRole;
import org.apache.ibatis.annotations.Insert;

public interface OrganizeRoleMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xkey_organize_role
     *
     * @mbggenerated
     */
    @Insert({
        "insert into xkey_organize_role (organize, role)",
        "values (#{organize,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR})"
    })
    int insert(OrganizeRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xkey_organize_role
     *
     * @mbggenerated
     */
    int insertSelective(OrganizeRole record);
}