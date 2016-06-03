package cn.shhuifu.analyse.dao;

import java.util.HashMap;

public interface UserDao {
    public HashMap<?, ?> findUser(String userName, String password);
}
