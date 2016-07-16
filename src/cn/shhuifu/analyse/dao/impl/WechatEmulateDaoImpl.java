package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinEmulateEntity;
import cn.shhuifu.analyse.dao.WechatEmulateDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.HashMap;
import java.util.List;

public class WechatEmulateDaoImpl implements WechatEmulateDao {
    private DbutilsTemplate dbutilsTemplate;

    private String queryCondition(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity) {
        String sql = " WHERE ";
        if (cswebTencentWeixinEmulateEntity.getAppId() != null && !cswebTencentWeixinEmulateEntity.getAppId().equals(""))
            sql += " APP_ID = '" + cswebTencentWeixinEmulateEntity.getAppId() + "' AND ";
        if (cswebTencentWeixinEmulateEntity.getComputerId() != null && !cswebTencentWeixinEmulateEntity.getComputerId().equals(""))
            sql += " COMPUTER_ID = '" + cswebTencentWeixinEmulateEntity.getComputerId() + "' AND ";

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
    public List<HashMap<?, ?>> find_emulate(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity) {
        String sql = "SELECT * FROM data_weixin_user.csweb_tencent_weixin_emulate";
        sql += queryCondition(cswebTencentWeixinEmulateEntity);
        sql += " LIMIT ?,? ";
        Object[] params = {(cswebTencentWeixinEmulateEntity.getPage() - 1) * cswebTencentWeixinEmulateEntity.getSize(), cswebTencentWeixinEmulateEntity.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @Override
    @SuppressWarnings("unchecked")
    public long find_total(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity) {
        String sql = "SELECT count(*) FROM data_weixin_user.csweb_tencent_weixin_emulate";
        sql += queryCondition(cswebTencentWeixinEmulateEntity);
        return (long) this.getDbutilsTemplate().find(sql, new ScalarHandler<Long>());
    }
}
