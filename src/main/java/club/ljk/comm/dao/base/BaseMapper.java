package club.ljk.comm.dao.base;

import club.ljk.comm.model.base.BaseModel;
import club.ljk.comm.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * base mapper
 * Created by XKey on 2015/11/21.
 */
public interface BaseMapper<T extends BaseModel> {
    T selectByPrimaryKey(String key);

    int insert(T record);

    int deleteByPrimaryKey(String key);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

    List<T> selectByExample(Object example);

    List<T> selectByPage(T record);

    List<T> selectModel(T record);
}
