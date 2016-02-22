package club.ljk.admin.menu.controller;

import club.ljk.admin.menu.service.MenuService;
import club.ljk.comm.controller.base.BaseController;
import club.ljk.comm.model.Menu;
import club.ljk.comm.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

/**
 * 菜单controller
 * Created by XKey on 2016/1/18.
 */
@Controller
@RequestMapping("/admin/menu/")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("moa")
    @ResponseBody
    public Map<String, Object> moa(@Valid Menu menu, BindingResult result) throws Exception {
        Map<String, Object> resultMap = error();
        if (result.hasErrors()) {
            resultMap.put("menu", menu);
            resultMap.put("errors", result.getAllErrors());
            return resultMap;
        }

        if(StringUtils.isEmpty(menu.getMenuId())) {
            menuService.save(menu);
        }else {
            menuService.modifyNotNull(menu);
        }
        return success();
    }

    @RequestMapping("initEdit")
    public String initEdit(ModelMap map,
            @RequestParam(required = false, defaultValue = "") String key) throws Exception {
        if(StringUtils.isNotEmpty(key)) {
            map.put("record", menuService.get(key));
        }
        map.put("topMenus", menuService.findTopLevel());
        return "admin/menu/menu_edit";
    }

    @RequestMapping("listPage")
    public String listPage(Menu menu, ModelMap map,
                           @RequestParam(required = false, defaultValue = "1") Integer pageNo) throws Exception {
        Page page = new Page(pageNo);
        map.put("records", menuService.findByPage(menu, page));
        map.put("page", page);
        return "admin/menu/menu_list";
    }
}
