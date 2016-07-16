package cn.shhuifu.analyse.dao.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareData;
import cn.shhuifu.analyse.dao.OpenApiDao;
import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2016/7/16.
 */
@Repository
public class OpenApiDaoImpl implements OpenApiDao {
    @Autowired
    private DbutilsTemplate dbutilsTemplate;

    @Override
    public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp) {
        String sql="select * FROM data_weixin_user.csweb_tencent_weixin_share_data  where UNIX_TIMESTAMP(SHARE_TIME)- ? <="+1000*60*60*24+" and UNIX_TIMESTAMP(SHARE_TIME)- ? >0";
        Object [] params={timestamp,timestamp};
        return (List<HashMap<?, ?>>) this.dbutilsTemplate.find(sql, params, new MapListHandler());
    }

    @Override
    public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp, int page, int size) {
        return null;
    }
}
