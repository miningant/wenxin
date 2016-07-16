package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebTencentWeixinComputerEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatComputerService {
    public List<HashMap<?, ?>> find_computer(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity);

    public long find_total(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity);
}
