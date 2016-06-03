package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import cn.shhuifu.analyse.dao.WechatShareDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.HashMap;
import java.util.List;

public class WechatShareDaoImpl implements WechatShareDao {
    private DbutilsTemplate dbutilsTemplate;

    private String queryCondition(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        String sql = " WHERE ";
        if (cswebTencentWeixinShareDataEntity.getCustId() != 0)
            sql += " CUST_ID = " + cswebTencentWeixinShareDataEntity.getCustId() + " AND ";
        if (cswebTencentWeixinShareDataEntity.getAppId() != null && !cswebTencentWeixinShareDataEntity.getAppId().equals(""))
            sql += " APP_ID = '" + cswebTencentWeixinShareDataEntity.getAppId() + "' AND ";
        if (cswebTencentWeixinShareDataEntity.getShareTitle() != null && !cswebTencentWeixinShareDataEntity.getShareTitle().equals(""))
            sql += " SHARE_TITLE = '" + cswebTencentWeixinShareDataEntity.getShareTitle() + "' AND ";
        if (cswebTencentWeixinShareDataEntity.getShareType() != null && !cswebTencentWeixinShareDataEntity.getShareType().equals(""))
            sql += " SHARE_TYPE = '" + cswebTencentWeixinShareDataEntity.getShareType() + "' AND ";
        if (cswebTencentWeixinShareDataEntity.getShareStatus() != null && !cswebTencentWeixinShareDataEntity.getShareStatus().equals(""))
            sql += " SHARE_STATUS = '" + cswebTencentWeixinShareDataEntity.getShareStatus() + "' AND ";

        sql += " 1=1 ";

        return sql;
    }

    public DbutilsTemplate getDbutilsTemplate() {
        return dbutilsTemplate;
    }

    public void setDbutilsTemplate(DbutilsTemplate dbutilsTemplate) {
        this.dbutilsTemplate = dbutilsTemplate;
    }

    @SuppressWarnings("unchecked")
    public List<HashMap<?, ?>> findShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        String sql = "SELECT * FROM data_weixin_user.csweb_tencent_weixin_share_data";
        sql += queryCondition(cswebTencentWeixinShareDataEntity);
        sql += " ORDER BY CREATE_TIME DESC LIMIT ?,? ";
        Object[] params = {(cswebTencentWeixinShareDataEntity.getPage() - 1) * cswebTencentWeixinShareDataEntity.getSize(), cswebTencentWeixinShareDataEntity.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new MapListHandler());
    }

    @Override
    public void createShare(Object[] params) {
        String sql = "INSERT INTO data_weixin_user.csweb_tencent_weixin_share_data (`APP_ID`, `SHARE_STATUS`, `SHARE_TYPE`, `SHARE_URL`, `SHARE_TITLE`, `SHARE_INFO01`, `SHARE_INFO02`, `SHARE_INFO03`, `SHARE_INFO04`, `SHARE_PIC_01`, `SHARE_PIC_02`, `SHARE_PIC_03`, `SHARE_PIC_04`, `SHARE_PIC_05`, `SHARE_PIC_06`, `SHARE_PIC_07`, `SHARE_PIC_08`, `SHARE_PIC_09`, `SHARE_TIME`, `CREATE_TIME`, `CREATE_USER`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.getDbutilsTemplate().update(sql, params);
    }

    @Override
    public void editShare(Object[] params) {
        String sql = "UPDATE data_weixin_user.csweb_tencent_weixin_share_data SET SHARE_STATUS = ? , SHARE_TYPE = ? , SHARE_URL = ? , SHARE_TITLE = ? , SHARE_INFO01 = ? , SHARE_INFO02 = ? , SHARE_INFO03 = ? , SHARE_INFO04 = ? , SHARE_PIC_01 = ? , SHARE_PIC_02 = ? , SHARE_PIC_03 = ? , SHARE_PIC_04 = ? , SHARE_PIC_05 = ? , SHARE_PIC_06 = ? , SHARE_PIC_07 = ? , SHARE_PIC_08 = ? , SHARE_PIC_09 = ? , SHARE_TIME = ? WHERE CUST_ID = ?";
        this.getDbutilsTemplate().update(sql, params);
    }


    @Override
    public void changeShareStatus(String status,String custId) {
        String sql="UPDATE data_weixin_user.csweb_tencent_weixin_share_data SET SHARE_STATUS = ? WHERE CUST_ID = ?";
        Object[] params={status,custId};
        this.getDbutilsTemplate().update(sql,params);
    }

    @Override
    public void deleteShare(String custId) {
        String sql = "DELETE FROM data_weixin_user.csweb_tencent_weixin_share_data WHERE CUST_ID = ? ";
        Object[] params = {custId};
        this.getDbutilsTemplate().update(sql, params);
    }

    @Override
    @SuppressWarnings("unchecked")
    public long find_total(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        String sql = "SELECT count(*) FROM data_weixin_user.csweb_tencent_weixin_share_data";
        sql += queryCondition(cswebTencentWeixinShareDataEntity);
        return (long) this.getDbutilsTemplate().find(sql, new ScalarHandler<>());
    }
}
