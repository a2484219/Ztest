package com.test;  

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaocongfei.dao.UserDao;
import com.yaocongfei.pojo.User;
import com.yaocongfei.service.UserService;

/**
 *
 * ���ܣ�
 * ���ߣ�lscm
 * ���ڣ�2016-5-17����1:32:05
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-test.xml"})
public class JunitTest {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test(){
		User user = new User();
		user.setUsername("jack");
		user.setPassword("111111");
		User uu = userDao.getUser(user);
		System.out.println(uu.getUsername());
		System.out.println(uu.getPassword());
	}
	
	@Test
	public void tests(){
		User user = new User();
		user.setUsername("jack");
		user.setPassword("111111");
		User uu = userService.getUser(user);
		System.out.println(uu.getUsername());
		System.out.println(uu.getPassword());
	}
}
 