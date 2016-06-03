package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebDataMobileUsersEntity;
import cn.shhuifu.analyse.dao.WechatMobileUserDao;
import cn.shhuifu.analyse.handler.MobileUserMapListHandler;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.HashMap;
import java.util.List;

public class WechatMobileUserDaoImpl implements WechatMobileUserDao {
    private DbutilsTemplate dbutilsTemplate;

    private String queryCondition(CswebDataMobileUsersEntity cswebDataMobileUsersEntity) {
        String sql = " WHERE ";
        if (cswebDataMobileUsersEntity.getAppId() != null && !cswebDataMobileUsersEntity.getAppId().equals(""))
            sql += " APP_ID = '" + cswebDataMobileUsersEntity.getAppId() + "' AND ";
        if (cswebDataMobileUsersEntity.getCityNodeId() != null && !cswebDataMobileUsersEntity.getCityNodeId().equals("")) {
            if (cswebDataMobileUsersEntity.getCityIdLike().equals("LIKE") && !cswebDataMobileUsersEntity.getCityIdLike().equals(""))
                sql += " CITY_NODE_ID LIKE '" + cswebDataMobileUsersEntity.getCityNodeId() + "%' AND ";
            else if (cswebDataMobileUsersEntity.getCityIdLike().equals("=") && !cswebDataMobileUsersEntity.getCityIdLike().equals(""))
                sql += " CITY_NODE_ID = '" + cswebDataMobileUsersEntity.getCityNodeId() + "' AND ";
        }
        if (cswebDataMobileUsersEntity.getWeixinVerify() != null && !cswebDataMobileUsersEntity.getWeixinVerify().equals(""))
            sql += " WEIXIN_VERIFY = '" + cswebDataMobileUsersEntity.getWeixinVerify() + "' AND ";
        if (cswebDataMobileUsersEntity.getPhoneNo() != null && !cswebDataMobileUsersEntity.getPhoneNo().equals(""))
            sql += " PHONE_NO = '" + cswebDataMobileUsersEntity.getPhoneNo() + "' AND ";
        if (cswebDataMobileUsersEntity.getUserName() != null && !cswebDataMobileUsersEntity.getUserName().equals(""))
            sql += " USER_NAME = '" + cswebDataMobileUsersEntity.getUserName() + "' AND ";

        sql += " 1=1 ";

        if (cswebDataMobileUsersEntity.getSortField() != null && !cswebDataMobileUsersEntity.getSortField().equals("")) {
            sql += " ORDER BY " + cswebDataMobileUsersEntity.getSortField() + " ";
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
    public List<HashMap<?, ?>> find_mobile_user(CswebDataMobileUsersEntity cswebDataMobileUsersEntity) {
        String sql = "SELECT * FROM data_weixin_user.csweb_data_mobile_users";
        sql += queryCondition(cswebDataMobileUsersEntity);
        sql += " LIMIT ?,? ";
        Object[] params = {(cswebDataMobileUsersEntity.getPage() - 1) * cswebDataMobileUsersEntity.getSize(), cswebDataMobileUsersEntity.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MobileUserMapListHandler());
    }

    @Override
    public void create_mobile_user(Object[] params) throws Exception{
        String sql="INSERT INTO data_weixin_user.csweb_data_mobile_users (`APP_ID`, `PHONE_NO`, `USER_NAME`, `USER_SEX`, `USER_BIRTHDAY`, `USER_EMAIL`, `CITY_NODE_ID`, `USER_ADDRESS`, `ZIP_CODE`, `WEIXIN_VERIFY`, `UPDATE_TIME`, `CREATE_TIME`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.getDbutilsTemplate().update(sql,params);
    }

    @Override
    @SuppressWarnings("unchecked")
    public long find_total(CswebDataMobileUsersEntity cswebDataMobileUsersEntity) {
        String sql = "SELECT count(*) FROM data_weixin_user.csweb_data_mobile_users";
        sql += queryCondition(cswebDataMobileUsersEntity);
        return (long) this.getDbutilsTemplate().find(sql, new ScalarHandler<>());
    }
}
