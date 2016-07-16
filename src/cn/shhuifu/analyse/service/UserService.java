package cn.shhuifu.analyse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.shhuifu.analyse.beans.RequestParams;

public interface UserService {
    public HashMap<?, ?> findUser(String userName, String password);

    public boolean adminUserChangePassword(Map<?, ?> map);

    public List<HashMap<?, ?>> findComputer(RequestParams requestParams);

    public List<HashMap<?, ?>> findEmulate(RequestParams requestParams);

    public List<HashMap<?, ?>> findMobile(RequestParams requestParams);

    public List<HashMap<?, ?>> findWxusers(RequestParams requestParams);
}
