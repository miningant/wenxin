package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareHistoryEntity;
import cn.shhuifu.analyse.dao.WechatShareHistoryDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.HashMap;
import java.util.List;

public class WechatShareHistoryDaoImpl implements WechatShareHistoryDao {
    private DbutilsTemplate dbutilsTemplate;

    private String queryCondition(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity) {
        String sql = " WHERE ";
        //TODO APP_ID
        if (cswebTencentWeixinShareHistoryEntity.getWeixinUser() != null && !cswebTencentWeixinShareHistoryEntity.getWeixinUser().equals(""))
            sql += " WEIXIN_USER = '" + cswebTencentWeixinShareHistoryEntity.getWeixinUser() + "' AND ";
        //TODO SHARE_TITLE
        if (cswebTencentWeixinShareHistoryEntity.getShareStatus() != null && !cswebTencentWeixinShareHistoryEntity.getShareStatus().equals(""))
            sql += " SHARE_STATUS = '" + cswebTencentWeixinShareHistoryEntity.getShareStatus() + "' AND ";

        sql += " 1=1 ";

        return sql;
    }

    public DbutilsTemplate getDbutilsTemplate() {
        return dbutilsTemplate;
    }

    public void setDbutilsTemplate(DbutilsTemplate dbutilsTemplate) {
        this.dbutilsTemplate = dbutilsTemplate;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<HashMap<?, ?>> find_share_history(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity) {
        String sql = "SELECT * FROM data_weixin_user.csweb_tencent_weixin_share_history";
        sql += queryCondition(cswebTencentWeixinShareHistoryEntity);
        sql += " LIMIT ?,? ";
        Object[] params = {(cswebTencentWeixinShareHistoryEntity.getPage() - 1) * cswebTencentWeixinShareHistoryEntity.getSize(), cswebTencentWeixinShareHistoryEntity.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @Override
    @SuppressWarnings("unchecked")
    public long find_total(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity) {
        String sql = "SELECT count(*) FROM data_weixin_user.csweb_tencent_weixin_share_history";
        sql += queryCondition(cswebTencentWeixinShareHistoryEntity);
        return (long) this.getDbutilsTemplate().find(sql, new ScalarHandler<Long>());
    }
}
