package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebDataMobileUsersEntity;

import java.util.HashMap;
import java.util.List;

public interface WechatMobileUserDao {
    public List<HashMap<?, ?>> find_mobile_user(CswebDataMobileUsersEntity cswebDataMobileUsersEntity);

    public void create_mobile_user(Object[] params) throws Exception;

    public long find_total(CswebDataMobileUsersEntity cswebDataMobileUsersEntity);
}
