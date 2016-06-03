package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinComputerEntity;
import cn.shhuifu.analyse.dao.WechatComputerDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.HashMap;
import java.util.List;

public class WechatComputerDaoImpl implements WechatComputerDao {
    private DbutilsTemplate dbutilsTemplate;

    private String queryCondition(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity) {
        String sql = " WHERE ";
        if (cswebTencentWeixinComputerEntity.getAppId() != null && !cswebTencentWeixinComputerEntity.getAppId().equals(""))
            sql += " APP_ID = '" + cswebTencentWeixinComputerEntity.getAppId() + "' AND ";

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
    public List<HashMap<?, ?>> find_computer(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity) {
        String sql = "SELECT * FROM data_weixin_user.csweb_tencent_weixin_computer";
        sql += queryCondition(cswebTencentWeixinComputerEntity);
        sql += " LIMIT ?,? ";
        Object[] params = {(cswebTencentWeixinComputerEntity.getPage() - 1) * cswebTencentWeixinComputerEntity.getSize(), cswebTencentWeixinComputerEntity.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @Override
    @SuppressWarnings("unchecked")
    public long find_total(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity) {
        String sql = "SELECT count(*) FROM data_weixin_user.csweb_tencent_weixin_computer";
        sql += queryCondition(cswebTencentWeixinComputerEntity);
        return (long) this.getDbutilsTemplate().find(sql, new ScalarHandler<>());
    }
}
