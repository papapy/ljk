package club.ljk.comm.controller;

import club.ljk.admin.menu.service.MenuService;
import club.ljk.comm.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 共用Controller
 * Created by XKey on 2015/11/24.
 */
@Controller
public class CommController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String root(ModelMap map) {
        map.put("menus", menuService.findTopLevel());
        return "/admin/comm/index";
    }
}
