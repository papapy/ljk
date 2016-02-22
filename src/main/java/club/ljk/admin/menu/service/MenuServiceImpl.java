package club.ljk.admin.menu.service;

import club.ljk.comm.dao.MenuMapper;
import club.ljk.comm.model.Menu;
import club.ljk.comm.util.ConstantUtils;
import club.ljk.comm.util.IDGenerator;
import club.ljk.comm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Menu Service Impl
 * Created by XKey on 2016/1/18.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> findTopLevel() {
        return menuMapper.selectTopLevel();
    }

    public List<Menu> findAllEffective() {
        Menu menu = new Menu();
        menu.setMenuIsDel(ConstantUtils.EFFECTIVE_FLAG.NO_DEL);
        return menuMapper.selectModel(menu);
    }

    public Menu get(String key) {
        return menuMapper.selectByPrimaryKey(key);
    }

    public int save(Menu entity) {
        entity.setMenuId(IDGenerator.getUUID());
        return menuMapper.insert(entity);
    }

    public int remove(String key) {
        return menuMapper.deleteByPrimaryKey(key);
    }

    public int modifyAll(Menu entity) {
        return menuMapper.updateByPrimaryKey(entity);
    }

    public int modifyNotNull(Menu entity) {
        return menuMapper.updateByPrimaryKeySelective(entity);
    }

    public List<Menu> findByExample(Object example) {
        return menuMapper.selectByExample(example);
    }

    public List<Menu> findByPage(Menu entity, Page page) {
        entity.setPage(page);
        return menuMapper.selectByPage(entity);
    }
}
