package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinEmulateEntity;
import cn.shhuifu.analyse.dao.WechatEmulateDao;
import cn.shhuifu.analyse.service.WechatEmulateService;

import java.util.HashMap;
import java.util.List;

public class WechatEmulateServiceImpl implements WechatEmulateService {
    private WechatEmulateDao wechatEmulateDao;

    public void setWechatEmulateDao(WechatEmulateDao wechatEmulateDao) {
        this.wechatEmulateDao = wechatEmulateDao;
    }

    @Override
    public List<HashMap<?, ?>> find_emulate(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity) {
        return this.wechatEmulateDao.find_emulate(cswebTencentWeixinEmulateEntity);
    }

    @Override
    public long find_total(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity) {
        return this.wechatEmulateDao.find_total(cswebTencentWeixinEmulateEntity);
    }
}
