package com.jd.bdp.order.springmybatis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jd.bdp.order.servers.OrderServers;

public class TestSpringMybatis {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext("spring.xml");
		OrderServers orderServers = appContext.getBean(OrderServers.class);
		orderServers.insertUser();
	}
}
