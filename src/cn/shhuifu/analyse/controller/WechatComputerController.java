package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebTencentWeixinComputerEntity;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.WechatComputerService;
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
public class WechatComputerController {
    private WechatComputerService wechatComputerService;

    @Autowired
    public void setWechatComputerService(WechatComputerService wechatComputerService) {
        this.wechatComputerService = wechatComputerService;
    }

    /**
     * 远程终端查询
     *
     * @param cswebTencentWeixinComputerEntity
     * @return
     */
    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryComputer(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity) {
        if (cswebTencentWeixinComputerEntity == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.wechatComputerService.find_computer(cswebTencentWeixinComputerEntity);
            long total = this.wechatComputerService.find_total(cswebTencentWeixinComputerEntity);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }
}
