package cn.shhuifu.analyse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.shhuifu.analyse.beans.RequestParams;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.UserService;

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

    /**
     * 用户修改密码
     *
     * @param userName
     * @param params
     * @return
     */
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.PUT)
    @ResponseBody
    public Object userReset(@PathVariable("userName") String userName, @RequestBody JSONObject params) {
        if (userName == null || params == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            params.put("userName", userName);
            return ResMap.resultMap(this.userService.adminUserChangePassword(params) ? ResMap.SUCCESS : ResMap.ERROR, null);
        }
    }

    /**
     * 电脑查询
     *
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    @ResponseBody
    public Object queryComputer(RequestParams requestParams) {
        if (requestParams == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.userService.findComputer(requestParams);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result);
        }
    }

    /**
     * 手机查询
     *
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/emulate", method = RequestMethod.GET)
    @ResponseBody
    public Object queryEmulate(RequestParams requestParams) {
        if (requestParams == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.userService.findEmulate(requestParams);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result);
        }
    }

    /**
     * 手机号查询
     *
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/mobile", method = RequestMethod.GET)
    @ResponseBody
    public Object queryMobile(RequestParams requestParams) {
        if (requestParams == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.userService.findMobile(requestParams);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result);
        }
    }

    /**
     * 手机号导入
     *
     * @param attach
     * @return
     */
    @RequestMapping(value = "/mobileupload")
    @ResponseBody
    public Object uploadMobile(@RequestParam(value = "attach", required = false) MultipartFile attach) {
//		String attachFileName = attach.getOriginalFilename();
//		System.out.println(attachFileName);
        System.out.println("文件类型：" + attach.getContentType());
        System.out.println("文件名称：" + attach.getOriginalFilename());
        System.out.println("文件大小：" + attach.getSize());


        return ResMap.resultMap(ResMap.SUCCESS, null);
    }

    /**
     * 微信号查询
     *
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/wxusers", method = RequestMethod.GET)
    @ResponseBody
    public Object queryWxusers(RequestParams requestParams) {
        if (requestParams == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.userService.findWxusers(requestParams);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result);
        }
    }
}
