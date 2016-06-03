package cn.shhuifu.analyse.service;

import java.util.HashMap;

public interface UserService {
    public HashMap<?, ?> findUser(String userName, String password);
}
