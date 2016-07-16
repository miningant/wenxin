package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinComputerEntity;
import cn.shhuifu.analyse.dao.WechatComputerDao;
import cn.shhuifu.analyse.service.WechatComputerService;

import java.util.HashMap;
import java.util.List;

public class WechatComputerServiceImpl implements WechatComputerService {
    private WechatComputerDao wechatComputerDao;

    public void setWechatComputerDao(WechatComputerDao wechatComputerDao) {
        this.wechatComputerDao = wechatComputerDao;
    }

    @Override
    public List<HashMap<?, ?>> find_computer(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity) {
        return this.wechatComputerDao.find_computer(cswebTencentWeixinComputerEntity);
    }

    @Override
    public long find_total(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity) {
        return this.wechatComputerDao.find_total(cswebTencentWeixinComputerEntity);
    }
}
