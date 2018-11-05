package com.kaiji.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kaiji.model.User;
import com.kaiji.service.UserService;

@Controller
public class UserLoginController {

	private static final Logger __logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value= {"/", "/index"}, method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		try {
			__logger.info("哈哈， 呵呵 。。 嘻嘻~~~");
			List<User> userList = userService.getAll();
			System.out.println(userList);
			__logger.info("index getById");
			User user = userService.getById(userList.get(0).getId());
			System.out.println(user);
			Map<String, Object> filterMap = new HashMap<>();
			filterMap.put("id", user.getId());
			filterMap.put("name", user.getName());
			List<User> filterList = userService.findByFilter(filterMap);
			System.out.println(filterList);
			mv.addObject("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;
	}
}
