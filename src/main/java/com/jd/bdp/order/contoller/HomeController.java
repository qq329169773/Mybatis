package com.jd.bdp.order.contoller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jd.bdp.order.model.User;
import com.jd.bdp.order.servers.OrderServers;

 
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private OrderServers orderServers ;
  	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
 		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("userName","zhangsan");
		return "hello";
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Locale locale, Model model) {
 	/*	Map<String, String> hashMap = new HashMap<String, String>();
 		hashMap.put("a", "a1");
 		hashMap.put("b", "b1");
 

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("userName","zhangsan");
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("map", hashMap );
		Users users = new Users();
  		model.addAttribute("user",  users );*/
		return "hello";
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.GET , produces = "text/json")
	@ResponseBody
	public String addUser(){
		User user =	orderServers.insertUser();
 		return JSON.toJSONString(user);
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET , produces = "text/json")
	@ResponseBody
	public String list(){
		List<User> user =	orderServers.getUsers();
 		return JSON.toJSONString(user);
	}
}
