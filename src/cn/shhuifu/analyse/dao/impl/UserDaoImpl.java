package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.dao.UserDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.util.HashMap;

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
}
