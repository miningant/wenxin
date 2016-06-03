package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareHistoryEntity;
import cn.shhuifu.analyse.dao.WechatShareHistoryDao;
import cn.shhuifu.analyse.service.WechatShareHistoryService;

import java.util.HashMap;
import java.util.List;

public class WechatShareHistoryServiceImpl implements WechatShareHistoryService {
    private WechatShareHistoryDao wechatShareHistoryDao;

    public void setWechatShareHistoryDao(WechatShareHistoryDao wechatShareHistoryDao) {
        this.wechatShareHistoryDao = wechatShareHistoryDao;
    }

    @Override
    public List<HashMap<?, ?>> find_share_history(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity) {
        return this.wechatShareHistoryDao.find_share_history(cswebTencentWeixinShareHistoryEntity);
    }

    @Override
    public long find_total(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity) {
        return this.wechatShareHistoryDao.find_total(cswebTencentWeixinShareHistoryEntity);
    }
}
