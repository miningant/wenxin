package cn.shhuifu.analyse.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.shhuifu.analyse.beans.RequestParams;
import cn.shhuifu.analyse.dao.UserDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;

public class UserDaoImpl implements UserDao {
    private DbutilsTemplate dbutilsTemplate;

    public DbutilsTemplate getDbutilsTemplate() {
        return dbutilsTemplate;
    }

    public void setDbutilsTemplate(DbutilsTemplate dbutilsTemplate) {
        this.dbutilsTemplate = dbutilsTemplate;
    }

    public HashMap<?, ?> findUser(String userName, String password) {
        String sql = "SELECT * FROM data_csweb_dmp.csweb_admin_users WHERE USER_ID = ? AND PASS_WORD = ?";
        Object[] params = {userName, password};
        return (HashMap<?, ?>) this.getDbutilsTemplate().find(sql, params, new MapHandler());
    }

    public int adminUserChangePassword(Map<?, ?> map) {
        String sql = "UPDATE data_csweb_dmp.csweb_admin_users SET PASS_WORD = ? WHERE USER_ID = ? AND PASS_WORD = ?";
        Object[] params = {DigestUtils.md5Hex(map.get("newPassword").toString()), map.get("userName"), DigestUtils.md5Hex(map.get("oldPassword").toString())};
        return this.getDbutilsTemplate().update(sql, params);
    }

    @SuppressWarnings("unchecked")
    public List<HashMap<?, ?>> findComputer(RequestParams requestParams) {
        String sql = "SELECT CUST_ID,APP_ID,COMPUTER_ID,COMPUTER_NAME,COMPUTER_VIEW,COMPUTER_IP,ONLINE_TIME FROM data_weixin_user.csweb_tencent_weixin_computer AS t1 WHERE EXISTS (SELECT APP_ID FROM data_csweb_dmp.csweb_admin_applications AS t2 WHERE NODE_ID LIKE ? AND t1.APP_ID = t2.APP_ID) ORDER BY CUST_ID LIMIT ?,?";
        Object[] params = {requestParams.getNodeId() + "%", (requestParams.getPage() - 1) * requestParams.getSize(), requestParams.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @SuppressWarnings("unchecked")
    public List<HashMap<?, ?>> findEmulate(RequestParams requestParams) {
        String sql = "SELECT CUST_ID,APP_ID,COMPUTER_ID,ANDROID_ID,ANDROID_NAME,ONLINE_TIME,WEIXIN_USER,WEIXIN_PASS FROM data_weixin_user.csweb_tencent_weixin_emulate AS t1 WHERE EXISTS (SELECT APP_ID FROM data_csweb_dmp.csweb_admin_applications AS t2 WHERE NODE_ID LIKE ? AND t1.APP_ID = t2.APP_ID) ORDER BY CUST_ID LIMIT ?,?";
        Object[] params = {requestParams.getNodeId() + "%", (requestParams.getPage() - 1) * requestParams.getSize(), requestParams.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @SuppressWarnings("unchecked")
    public List<HashMap<?, ?>> findMobile(RequestParams requestParams) {
        String sql = "SELECT CUST_ID,APP_ID,PHONE_NO,USER_NAME,USER_SEX,WEIXIN_VERIFY,CITY_NODE_ID,USER_ADDRESS,ZIP_CODE,USER_EMAIL,USER_BIRTHDAY FROM data_weixin_user.csweb_data_mobile_users AS t1 WHERE EXISTS (SELECT APP_ID FROM data_csweb_dmp.csweb_admin_applications AS t2 WHERE NODE_ID LIKE ? AND t1.APP_ID = t2.APP_ID) ORDER BY CUST_ID LIMIT ?,?";
        Object[] params = {requestParams.getNodeId() + "%", (requestParams.getPage() - 1) * requestParams.getSize(), requestParams.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @SuppressWarnings("unchecked")
    public List<HashMap<?, ?>> findWxusers(RequestParams requestParams) {
        boolean phoneNo = (null == requestParams.getPhoneNo() || requestParams.getPhoneNo().equals("")) ? true : false;
        boolean weixinSignal = (null == requestParams.getWeixinSignal() || requestParams.getWeixinSignal().equals("")) ? true : false;
        String sql = "SELECT CUST_ID,APP_ID,PHONE_NO,CITY_NODE_ID,USER_NAME,USER_SEX,USER_BIRTHDAY,WEIXIN_HEAD,WEIXIN_NAME,WEIXIN_SIGNAL FROM data_weixin_user.csweb_tencent_weixin_users AS t1 WHERE EXISTS (SELECT APP_ID FROM data_csweb_dmp.csweb_admin_applications AS t2 WHERE NODE_ID LIKE ? AND t1.APP_ID = t2.APP_ID) " + (phoneNo ? " AND 1 = ? " : " AND PHONE_NO = ? ") + (weixinSignal ? " AND 1 = ? " : " AND WEIXIN_SIGNAL = ? ") + " ORDER BY CUST_ID LIMIT ?,?";
        Object[] params = {requestParams.getNodeId() + "%", (phoneNo ? 1 : requestParams.getPhoneNo()), (weixinSignal ? 1 : requestParams.getWeixinSignal()), (requestParams.getPage() - 1) * requestParams.getSize(), requestParams.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }
}
