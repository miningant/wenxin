package cn.shhuifu.analyse.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import cn.shhuifu.analyse.beans.RequestParams;
import cn.shhuifu.analyse.dao.UserDao;
import cn.shhuifu.analyse.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public HashMap<?, ?> findUser(String userName, String password) {
		return this.userDao.findUser(userName,DigestUtils.md5Hex(password));
	}

	public boolean adminUserChangePassword(Map<?, ?> map) {
		return this.userDao.adminUserChangePassword(map)==0?false:true;
	}

	public List<HashMap<?, ?>> findComputer(RequestParams requestParams) {
		return this.userDao.findComputer(requestParams);
	}

	public List<HashMap<?, ?>> findEmulate(RequestParams requestParams) {
		return this.userDao.findEmulate(requestParams);
	}

	public List<HashMap<?, ?>> findMobile(RequestParams requestParams) {
		return this.userDao.findMobile(requestParams);
	}

	public List<HashMap<?, ?>> findWxusers(RequestParams requestParams) {
		return this.userDao.findWxusers(requestParams);
	}
}
