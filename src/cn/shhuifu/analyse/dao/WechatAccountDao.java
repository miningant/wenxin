package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebTencentWeixinUsersEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatAccountDao {
    public List<HashMap<?, ?>> find_user(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity);
    public long find_total(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity);
}
