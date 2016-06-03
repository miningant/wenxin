package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebTencentWeixinEmulateEntity;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.WechatEmulateService;
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
public class WechatEmulateController {
    private WechatEmulateService wechatEmulateService;

    @Autowired
    public void setWechatEmulateService(WechatEmulateService wechatEmulateService) {
        this.wechatEmulateService = wechatEmulateService;
    }

    /**
     * 模拟手机查询
     *
     * @param cswebTencentWeixinEmulateEntity
     * @return
     */
    @RequestMapping(value = "/emulate", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryEmulate(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity) {
        if (cswebTencentWeixinEmulateEntity == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.wechatEmulateService.find_emulate(cswebTencentWeixinEmulateEntity);
            long total = this.wechatEmulateService.find_total(cswebTencentWeixinEmulateEntity);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }
}
