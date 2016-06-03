package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebTencentWeixinUsersEntity;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.WechatAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
@Scope("prototype")
public class WechatAccountController {
    private WechatAccountService wechatAccountService;

    @Autowired
    public void setWechatAccountService(WechatAccountService wechatAccountService) {
        this.wechatAccountService = wechatAccountService;
    }

    /**
     * 微信账号查询
     *
     * @param cswebTencentWeixinUsersEntity
     * @return
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryAccount(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity) {
        if (cswebTencentWeixinUsersEntity == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.wechatAccountService.find_user(cswebTencentWeixinUsersEntity);
            long total = this.wechatAccountService.find_total(cswebTencentWeixinUsersEntity);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }
}
