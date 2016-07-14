package com.jd.bdp.order.servers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jd.bdp.order.contoller.Users;
import com.jd.bdp.order.mybatis.CopyOfUserDaoIface;
import com.jd.bdp.order.mybatis.UserDaoIface;

@Service
@Transactional
public class OrderServers {

	@Autowired
	private UserDaoIface userDao ;
	
	@Autowired
	private CopyOfUserDaoIface  UserDaoIfa ;
	
	public void getUser(){
		Users users = userDao.getUserByIdSpring(1);
		System.out.println(users.getUser_id() + " :" + users.getUser_name());
 	}
	public long insertUser(){
		Users users = new Users();
		users.setSale(23);
		users.setEmail("3434");
		users.setUser_name("343434");
		userDao.insertUserSingle(users);
		System.out.println("insert user id : " + users.getUser_id() );
		UserDaoIfa.save();
 		int i = 1 / 0 ;
		return users.getUser_id() ;
	}
}
