package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinQuestion;
import cn.shhuifu.analyse.dao.WechatQuestionDao;
import cn.shhuifu.analyse.service.WechatQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2016/7/25.
 */
@Service
public class WechatQuestionServiceImpl implements WechatQuestionService {
    @Autowired
    private WechatQuestionDao wechatQuestionDao;
    @Override
    public List<Map<?, ?>> findQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion) {
        Object[] params={cswebTencentWeixinQuestion.getQuestionId(),cswebTencentWeixinQuestion.getQuestionTitle(),(cswebTencentWeixinQuestion.getPage()-1)*cswebTencentWeixinQuestion.getSize(),cswebTencentWeixinQuestion.getSize()};
        return wechatQuestionDao.findQuestion(params);
    }

    @Override
    public long findTotal(CswebTencentWeixinQuestion cswebTencentWeixinQuestion) {
        Object[] params={cswebTencentWeixinQuestion.getQuestionId(),cswebTencentWeixinQuestion.getQuestionTitle()};
        return wechatQuestionDao.findTotal(params);
    }

    @Override
    public void updateQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion) {
        Object[] params={cswebTencentWeixinQuestion.getQuestionTitle(),cswebTencentWeixinQuestion.getQuestionLabels(),cswebTencentWeixinQuestion.getQuestionAnswer(),cswebTencentWeixinQuestion.getQuestionId()};
        wechatQuestionDao.updateQuestion(params);
    }

    @Override
    public void createQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion) {
        Object[] params={cswebTencentWeixinQuestion.getQuestionTitle(),cswebTencentWeixinQuestion.getQuestionLabels(),cswebTencentWeixinQuestion.getQuestionAnswer()
        ,cswebTencentWeixinQuestion.getCreateUserId(),new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())};
        wechatQuestionDao.createQuestion(params);
    }

    @Override
    public void deleteQuestion(CswebTencentWeixinQuestion cswebTencentWeixinQuestion) {
        Object[] params={cswebTencentWeixinQuestion.getQuestionId()};
        wechatQuestionDao.deleteQuestion(params);
    }
}
