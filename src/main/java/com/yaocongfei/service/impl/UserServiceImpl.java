package com.yaocongfei.service.impl;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaocongfei.dao.UserDao;
import com.yaocongfei.pojo.User;
import com.yaocongfei.service.UserService;

/**
 *
 * ���ܣ�
 * ���ߣ�lscm
 * ���ڣ�2016-5-17����3:06:44
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
 
