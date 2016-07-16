package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebTencentWeixinEmulateEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatEmulateService {
    public List<HashMap<?, ?>> find_emulate(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity);

    public long find_total(CswebTencentWeixinEmulateEntity cswebTencentWeixinEmulateEntity);
}
