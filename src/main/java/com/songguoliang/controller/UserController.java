package com.songguoliang.controller;

import com.songguoliang.base.BaseController;
import com.songguoliang.entity.User;
import com.songguoliang.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-14 10:42
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 修改密码页
     *
     * @return
     */
    @GetMapping("/editPwdPage")
    public String editPwdPage() {
        return "admin/user/userEditPwd";
    }

    /**
     * 修改密码
     *
     * @param oldPwd
     * @param pwd
     * @return
     */
    @PostMapping("/editUserPwd")
    @ResponseBody
    public Object editUserPwd(String oldPwd, String pwd) {
        User user = userService.selectById(getUserId());
        String salt = user.getSalt();
        if (!user.getPassword().equals(new SimpleHash("md5", oldPwd, salt, 1).toHex())) {
            return renderError("老密码不正确!");
        }
        userService.updatePwdByUserId(getUserId(), new SimpleHash("md5", pwd, salt, 1).toHex());
        return renderSuccess("密码修改成功！");
    }

}
