package com.jd.bdp.order.springmybatis;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jd.bdp.order.model.User;
import com.jd.bdp.order.servers.OrderServers;

public class TestSpringMybatis {

 static{
	 org.apache.ibatis.logging.LogFactory.useLog4JLogging();
 }
	public static void main(String[] args) {

		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext("spring.xml");
		OrderServers orderServers = appContext.getBean(OrderServers.class);
		//List<User> userList = orderServers.getUsers(null);
		
	}
}
