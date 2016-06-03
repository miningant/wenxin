package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebTencentWeixinUsersEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatAccountService {
    public List<HashMap<?, ?>> find_user(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity);

    public long find_total(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity);
}
