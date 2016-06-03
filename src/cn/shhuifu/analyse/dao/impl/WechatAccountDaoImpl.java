package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinUsersEntity;
import cn.shhuifu.analyse.dao.WechatAccountDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.HashMap;
import java.util.List;

public class WechatAccountDaoImpl implements WechatAccountDao {
    private DbutilsTemplate dbutilsTemplate;

    private String queryCondition(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity) {
        String sql = " WHERE ";
        if (cswebTencentWeixinUsersEntity.getAppId() != null && !cswebTencentWeixinUsersEntity.getAppId().equals(""))
            sql += " APP_ID = '" + cswebTencentWeixinUsersEntity.getAppId() + "' AND ";
        if (cswebTencentWeixinUsersEntity.getCityNodeId() != null && !cswebTencentWeixinUsersEntity.getCityNodeId().equals("")) {
            if (cswebTencentWeixinUsersEntity.getCityIdLike().equals("LIKE") && !cswebTencentWeixinUsersEntity.getCityIdLike().equals(""))
                sql += " CITY_NODE_ID LIKE '" + cswebTencentWeixinUsersEntity.getCityNodeId() + "%' AND ";
            else if (cswebTencentWeixinUsersEntity.getCityIdLike().equals("=") && !cswebTencentWeixinUsersEntity.getCityIdLike().equals(""))
                sql += " CITY_NODE_ID = '" + cswebTencentWeixinUsersEntity.getCityNodeId() + "' AND ";
        }
        if (cswebTencentWeixinUsersEntity.getPhoneNo() != null && !cswebTencentWeixinUsersEntity.getPhoneNo().equals(""))
            sql += " PHONE_NO = '" + cswebTencentWeixinUsersEntity.getPhoneNo() + "' AND ";
        if (cswebTencentWeixinUsersEntity.getWeixinName() != null && !cswebTencentWeixinUsersEntity.getWeixinName().equals(""))
            sql += " WEIXIN_NAME = '" + cswebTencentWeixinUsersEntity.getWeixinName() + "' AND ";
        if (cswebTencentWeixinUsersEntity.getWeixinUser() != null && !cswebTencentWeixinUsersEntity.getWeixinUser().equals(""))
            sql += " WEIXIN_USER = '" + cswebTencentWeixinUsersEntity.getWeixinName() + "' AND ";

        sql += " 1=1 ";

        if (cswebTencentWeixinUsersEntity.getSortField() != null && !cswebTencentWeixinUsersEntity.getSortField().equals("")) {
            sql += " ORDER BY " + cswebTencentWeixinUsersEntity.getSortField() + " ";
        }
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
    public List<HashMap<?, ?>> find_user(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity) {
        String sql = "SELECT * FROM data_weixin_user.csweb_tencent_weixin_users";
        sql += queryCondition(cswebTencentWeixinUsersEntity);
        sql += " LIMIT ?,? ";
        Object[] params = {(cswebTencentWeixinUsersEntity.getPage() - 1) * cswebTencentWeixinUsersEntity.getSize(), cswebTencentWeixinUsersEntity.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @Override
    @SuppressWarnings("unchecked")
    public long find_total(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity) {
        String sql = "SELECT count(*) FROM data_weixin_user.csweb_tencent_weixin_users";
        sql += queryCondition(cswebTencentWeixinUsersEntity);
        return (long) this.getDbutilsTemplate().find(sql, new ScalarHandler<>());
    }
}
