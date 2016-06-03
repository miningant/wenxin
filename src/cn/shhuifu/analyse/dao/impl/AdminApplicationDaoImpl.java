package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebAdminApplicationsEntity;
import cn.shhuifu.analyse.dao.AdminApplicationDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.util.HashMap;
import java.util.List;

public class AdminApplicationDaoImpl implements AdminApplicationDao {
    private DbutilsTemplate dbutilsTemplate;

    public DbutilsTemplate getDbutilsTemplate() {
        return dbutilsTemplate;
    }

    public void setDbutilsTemplate(DbutilsTemplate dbutilsTemplate) {
        this.dbutilsTemplate = dbutilsTemplate;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<HashMap<?, ?>> find_app(CswebAdminApplicationsEntity cswebAdminApplicationsEntity) {
        String sql = "SELECT * FROM data_csweb_dmp.csweb_admin_applications WHERE NODE_ID LIKE ?";
        Object[] params = {cswebAdminApplicationsEntity.getNodeId() + "%"};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }
}
