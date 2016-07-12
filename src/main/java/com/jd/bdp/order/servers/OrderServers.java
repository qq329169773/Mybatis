package com.jd.bdp.order.servers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.bdp.order.contoller.Users;
import com.jd.bdp.order.mybatis.UserIface;

@Service
public class OrderServers {

	@Autowired
	private UserIface userDao ;
	
	public void getUser(){
		Users users = userDao.getUserByIdSpring(1);
		System.out.println(users.getUser_id() + " :" + users.getUser_name());
 	}
}
