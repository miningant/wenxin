package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.dao.UserDao;
import cn.shhuifu.analyse.service.UserService;
import cn.shhuifu.analyse.util.MD5;

import java.util.HashMap;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public HashMap<?, ?> findUser(String userName, String password) {
        return this.userDao.findUser(userName, MD5.getMD5Str(password));
    }
}
