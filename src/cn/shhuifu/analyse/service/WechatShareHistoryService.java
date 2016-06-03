package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareHistoryEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatShareHistoryService {
    public List<HashMap<?, ?>> find_share_history(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity);

    public long find_total(CswebTencentWeixinShareHistoryEntity cswebTencentWeixinShareHistoryEntity);
}
