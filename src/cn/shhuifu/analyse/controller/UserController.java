package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/auth")
@Scope("prototype")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> userLogin(@PathVariable("userName") String userName, String password) {
        if (userName == null || password == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            HashMap<?, ?> result = this.userService.findUser(userName, password);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result);
        }
    }
}
