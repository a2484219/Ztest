package com.yaocongfei.service.impl;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaocongfei.dao.UserDao;
import com.yaocongfei.pojo.User;
import com.yaocongfei.service.UserService;

/**
 *
 * 功能：
 * 作者：lscm
 * 日期：2016-5-17下午3:06:44
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

}
 
