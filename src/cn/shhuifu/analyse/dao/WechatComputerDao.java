package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebTencentWeixinComputerEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatComputerDao {
    public List<HashMap<?, ?>> find_computer(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity);

    public long find_total(CswebTencentWeixinComputerEntity cswebTencentWeixinComputerEntity);
}
