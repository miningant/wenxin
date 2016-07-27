package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinQuestion;
import cn.shhuifu.analyse.dao.WechatQuestionDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2016/7/24.
 */
@Repository
public class WechatQuestionDaoImpl implements WechatQuestionDao {
    @Autowired
    private DbutilsTemplate dbutilsTemplate;

    @Override
    public List<Map<?, ?>> findQuestion(Object[] params) {
        boolean questionId;
        if (params[0] == null){
            questionId = true;
            params[0]=1;
        } else
            questionId = false;
        String sql="SELECT *from `data_weixin_user`.`csweb_tencent_weixin_question` where "+(questionId?"1=?":"question_id =?")+" and question_title like ? "+"LIMIT ?,? ";
        return (List<Map<?,?>>) dbutilsTemplate.find(sql,params,new MapListHandler());
    }

    @Override
    public long findTotal(Object[] params) {
        boolean questionId;
        if (params[0] == null){
            questionId = true;
            params[0]=1;
        } else questionId = false;
        String sql="SELECT count(*) from `data_weixin_user`.`csweb_tencent_weixin_question` where "+(questionId?"1=?":"question_id =?")+" and question_title like ? ";
        return (long) dbutilsTemplate.find(sql,params,new ScalarHandler<>());
    }

    @Override
    public void updateQuestion(Object[] params) {
        String sql="update `data_weixin_user`.`csweb_tencent_weixin_question` set question_title= ? ,question_labels= ? ,question_answer =? where question_id= ?";
        dbutilsTemplate.update(sql,params);
    }

    @Override
    public void createQuestion(Object[] params) {
        String sql="INSERT INTO data_weixin_user.csweb_tencent_weixin_question (question_title,question_labels,question_answer,create_user_id,create_time) VALUES(?,?,?,?,?)";
        dbutilsTemplate.insert(sql,params);
    }

    @Override
    public void deleteQuestion(Object[] params) {
        String sql="delete from data_weixin_user.csweb_tencent_weixin_question where question_id = ?";
        dbutilsTemplate.update(sql,params);
    }
}
