package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebTencentWeixinQuestion;

import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2016/7/24.
 */
public interface WechatQuestionDao {
    List<Map<?,?>> findQuestion(Object[] params);
    long findTotal(Object[] params);
    void updateQuestion(Object[] params);
    void createQuestion(Object[] params);
    void deleteQuestion(Object[] params);
}
