package club.ljk.comm.service;

import club.ljk.comm.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XKey on 2016/1/6.
 */
public interface IService<T> {
    T get(String key);

    int save(T entity);

    int remove(String key);

    int modifyAll(T entity);

    int modifyNotNull(T entity);

    List<T> findByExample(Object example);

    List<T> findByPage(T entity, Page page);
}
