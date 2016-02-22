package club.ljk.admin.menu.service;

import club.ljk.comm.model.Menu;
import club.ljk.comm.service.IService;

import java.util.List;

/**
 * Menu Service
 * Created by XKey on 2016/1/18.
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取所有有效菜单
     * @return list
     */
    List<Menu> findAllEffective();

    /**
     * 获取顶级菜单
     * @return list
     */
    List<Menu> findTopLevel();
}
