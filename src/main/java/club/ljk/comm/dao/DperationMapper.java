package club.ljk.comm.dao;

import club.ljk.comm.dao.base.BaseMapper;
import club.ljk.comm.model.Dperation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DperationMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xker_dperation
     *
     * @mbggenerated
     */
    @Delete({
        "delete from xker_dperation",
        "where dperation_id = #{dperationId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String dperationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xker_dperation
     *
     * @mbggenerated
     */
    @Insert({
        "insert into xker_dperation (dperation_id, dperation_name, ",
        "dperation_code, dperation_url_prefix, ",
        "dperation_parent, dperation_is_del, ",
        "dperation_create, dperation_time)",
        "values (#{dperationId,jdbcType=VARCHAR}, #{dperationName,jdbcType=VARCHAR}, ",
        "#{dperationCode,jdbcType=VARCHAR}, #{dperationUrlPrefix,jdbcType=VARCHAR}, ",
        "#{dperationParent,jdbcType=VARCHAR}, #{dperationIsDel,jdbcType=INTEGER}, ",
        "#{dperationCreate,jdbcType=VARCHAR}, #{dperationTime,jdbcType=TIMESTAMP})"
    })
    int insert(Dperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xker_dperation
     *
     * @mbggenerated
     */
    int insertSelective(Dperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xker_dperation
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "dperation_id, dperation_name, dperation_code, dperation_url_prefix, dperation_parent, ",
        "dperation_is_del, dperation_create, dperation_time",
        "from xker_dperation",
        "where dperation_id = #{dperationId,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Dperation selectByPrimaryKey(String dperationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xker_dperation
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Dperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xker_dperation
     *
     * @mbggenerated
     */
    @Update({
        "update xker_dperation",
        "set dperation_name = #{dperationName,jdbcType=VARCHAR},",
          "dperation_code = #{dperationCode,jdbcType=VARCHAR},",
          "dperation_url_prefix = #{dperationUrlPrefix,jdbcType=VARCHAR},",
          "dperation_parent = #{dperationParent,jdbcType=VARCHAR},",
          "dperation_is_del = #{dperationIsDel,jdbcType=INTEGER},",
          "dperation_create = #{dperationCreate,jdbcType=VARCHAR},",
          "dperation_time = #{dperationTime,jdbcType=TIMESTAMP}",
        "where dperation_id = #{dperationId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Dperation record);
}