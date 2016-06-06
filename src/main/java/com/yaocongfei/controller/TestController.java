package com.yaocongfei.controller;  



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaocongfei.pojo.User;
import com.yaocongfei.service.UserService;


/**
 *
 * 功能：控制器
 * 作者：lscm
 * 日期：2016-5-16下午6:06:35
 *
 */
@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("index")
	public String test(Integer id, User us){
		System.out.println("参数验证："+id);
		System.out.println("参数验证："+us.getUsername()+"\n"+us.getPassword());
		System.out.println("测试");
		User user = new User();
		user.setUsername("jack");
		user.setPassword("111111");
		User uu = userService.getUser(user);
		System.out.println(uu.getUsername());
		System.out.println(uu.getPassword());
		return "result";
	}
}
 
