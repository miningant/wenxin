package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebTencentWeixinQuestion;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.dao.WechatQuestionDao;
import cn.shhuifu.analyse.service.WechatQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by yang on 2016/7/24.
 */
@Controller
@RequestMapping("/api")
@Scope("prototype")
public class WechatQuestionController {
    @Autowired
    private WechatQuestionService wechatQuestionService;

    /**
     * 查询问题
     *
     * @param cswebTencentWeixinQuestion
     * @return
     */
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ResponseBody
    public Map findQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion) {
        if (cswebTencentWeixinQuestion == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            if (cswebTencentWeixinQuestion.getQuestionTitle() == null)
                cswebTencentWeixinQuestion.setQuestionTitle("");
            cswebTencentWeixinQuestion.setQuestionTitle("%" + cswebTencentWeixinQuestion.getQuestionTitle() + "%");
            List result = wechatQuestionService.findQuestion(cswebTencentWeixinQuestion);
            long total = wechatQuestionService.findTotal(cswebTencentWeixinQuestion);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }

    /**
     * 修改问题
     *
     * @param cswebTencentWeixinQuestion
     * @return
     */

    @RequestMapping(value = "/question", method = RequestMethod.PUT)
    @ResponseBody
    public Map updateQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion) {
        if (cswebTencentWeixinQuestion == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            wechatQuestionService.updateQuestion(cswebTencentWeixinQuestion);
            return ResMap.resultMap(ResMap.SUCCESS);
        }
    }

    /**
     * 添加问题
     * @param cswebTencentWeixinQuestion
     * @return
     */
    @RequestMapping(value="/question",method =RequestMethod.POST)
    @ResponseBody
    public Map createQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion){
        if (cswebTencentWeixinQuestion == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            wechatQuestionService.createQuestion(cswebTencentWeixinQuestion);
            return ResMap.resultMap(ResMap.SUCCESS);
        }
    }

    /**
     * 删除问题
     * @param cswebTencentWeixinQuestion
     * @return
     */

    @RequestMapping(value="/question",method = RequestMethod.DELETE)
    @ResponseBody
    public Map deleteQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion){
        if (cswebTencentWeixinQuestion == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            wechatQuestionService.deleteQuestion(cswebTencentWeixinQuestion);
            return ResMap.resultMap(ResMap.SUCCESS);
        }
    }
}
