package club.ljk.admin.user.service.impl;

import club.ljk.admin.user.service.UserService;
import club.ljk.comm.dao.UserMapper;
import club.ljk.comm.model.User;
import club.ljk.comm.util.IDGenerator;
import club.ljk.comm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XKey on 2016/1/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User get(String key) {
        return null;
    }

    public int save(User entity) {
        entity.setUserId(IDGenerator.getUUID());
        return userMapper.insert(entity);
    }

    public int remove(String key) {
        return 0;
    }

    public int modifyAll(User entity) {
        return 0;
    }

    public int modifyNotNull(User entity) {
        return 0;
    }

    public List<User> findByExample(Object example) {
        return null;
    }

    public List<User> findByPage(User entity, Page page) {
        entity.setPage(page);
        return userMapper.selectByPage(entity);
    }

    public void sayHello() {
        System.out.println("---------------------------hello----------------------------------------");
    }
}
