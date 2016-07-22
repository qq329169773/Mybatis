package com.jd.bdp.order.servers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jd.bdp.order.dao.UserDaoIface;
import com.jd.bdp.order.model.User;

@Service
@Transactional
public class OrderServers {

 
	
	private static final Logger logger = Logger.getLogger(OrderServers.class);
	@Autowired
	private UserDaoIface userDao ;
	
	
	public List<User> getUsers(){
		
		 return userDao.getUsers();
//		return pageCtrl ;
 	}
	
	public User insertUser(){
		System.out.println("insert");
		logger.error("insert");
		User user = new User();
		user.setSale(23);
		user.setDepart("JAVA"); 
		user.setUserName("zhangrui");
		userDao.insertUserSingle(user);
		return user ;
	}
 
}
