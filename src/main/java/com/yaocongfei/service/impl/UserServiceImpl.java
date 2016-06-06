package com.yaocongfei.service.impl;  

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ch.qos.logback.classic.Logger;

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

	private static final Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(User user) {
		log.info("getUser�����ڲ�");
		return userDao.getUser(user);
	}

}
 
