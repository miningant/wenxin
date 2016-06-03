package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinUsersEntity;
import cn.shhuifu.analyse.dao.WechatAccountDao;
import cn.shhuifu.analyse.service.WechatAccountService;

import java.util.HashMap;
import java.util.List;

public class WechatAccountServiceImpl implements WechatAccountService {
    private WechatAccountDao wechatAccountDao;

    public void setWechatAccountDao(WechatAccountDao wechatAccountDao) {
        this.wechatAccountDao = wechatAccountDao;
    }

    @Override
    public List<HashMap<?, ?>> find_user(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity) {
        return this.wechatAccountDao.find_user(cswebTencentWeixinUsersEntity);
    }

    @Override
    public long find_total(CswebTencentWeixinUsersEntity cswebTencentWeixinUsersEntity) {
        return this.wechatAccountDao.find_total(cswebTencentWeixinUsersEntity);
    }
}
