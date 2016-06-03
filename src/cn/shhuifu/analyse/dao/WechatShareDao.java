package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatShareDao {
    public List<HashMap<?, ?>> findShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity);

    public void createShare(Object[] params);

    public void editShare(Object[] params);

    public void changeShareStatus(String status,String custId);

    public void deleteShare(String custId);

    public long find_total(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity);
}
