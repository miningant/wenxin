package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebTencentWeixinQuestion;

import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2016/7/25.
 */
public interface WechatQuestionService {
    List<Map<?,?>> findQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion);
    long findTotal(CswebTencentWeixinQuestion cswebTencentWeixinQuestion);
    void updateQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion);
    void createQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion);

    void deleteQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion);
}
