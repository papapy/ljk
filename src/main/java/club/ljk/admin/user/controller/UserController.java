package club.ljk.admin.user.controller;

import club.ljk.admin.user.service.UserService;
import club.ljk.comm.controller.base.BaseController;
import club.ljk.comm.model.User;
import club.ljk.comm.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * 用户 controller
 * Created by XKey on 2016/1/7.
 */
@Controller
@RequestMapping("/admin/user/")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping("moa")
    @ResponseBody
    public Map<String, Object> save(@Valid User user, BindingResult result) throws Exception {
        Map<String, Object> resultMap = error();
        if (result.hasErrors()) {
            resultMap.put("user", user);
            resultMap.put("errors", result.getAllErrors());
            return resultMap;
        }

        if(StringUtils.isEmpty(user.getUserId())) {
            userService.save(user);
        }else {
            userService.modifyNotNull(user);
        }
        return success();
    }

    @RequestMapping("initEdit")
    public ModelAndView initEdit(@RequestParam(required = false, defaultValue = "") String key) {
        ModelAndView view = new ModelAndView("/admin/user/edit");
        if(StringUtils.isNotEmpty(key)) {
            view.addObject("record", userService.get(key));
        }
        return view;
    }

    @RequestMapping("listPage")
    public ModelAndView listPage(User user, @RequestParam(required = false, defaultValue = "1") String pageNo) {
        ModelAndView view = new ModelAndView("/admin/user/list");
        Page page = new Page(Integer.parseInt(pageNo), 5);
        view.addObject("records", userService.findByPage(user, page));
        view.addObject("page", page);
        return view;
    }
}
