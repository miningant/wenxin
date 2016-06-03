package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareHistoryEntity;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.WechatShareHistoryService;
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
public class WechatShareHistoryController {
    private WechatShareHistoryService wechatShareHistoryService;

    @Autowired
    public void setWechatShareHistoryService(WechatShareHistoryService wechatShareHistoryService) {
        this.wechatShareHistoryService = wechatShareHistoryService;
    }

    /**
     * 分享数据历史查询
     *
     * @param cswebTencentWeixinShareHistoryEntity
     * @return
     */
    @RequestMapping(value = "/share_history", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryShareHistory(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity) {
        if (cswebTencentWeixinShareHistoryEntity == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.wechatShareHistoryService.find_share_history(cswebTencentWeixinShareHistoryEntity);
            long total = this.wechatShareHistoryService.find_total(cswebTencentWeixinShareHistoryEntity);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }
}
