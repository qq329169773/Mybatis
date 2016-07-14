package com.jd.bdp.order.mybatis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jd.bdp.order.contoller.Users;

public class TestMyBatis {
	
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			Properties log4jResource = new Properties();
			log4jResource.load(Resources.getResourceAsReader("log4j.properties"));
			PropertyConfigurator.configure(log4jResource);
 			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			reader = Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
  			//Users user = (Users) session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1);
			UserDaoIface userIface = session.getMapper(UserDaoIface.class);
			 
			Users users = new Users();
			users.setSale(12);
			users.setUser_name("zhangrui1111");
			int count = userIface.updateUsers(1, users);
			System.out.println("count :" + count);
		} finally {
   			session.commit();
			session.close();
		}
	}

	private static void getMutipleSelect(UserDaoIface userIface) {
		List<Users> userList = userIface.getUserBySaleDepart(0, "Java");
		System.out.println("size : " + userList.size() );
	}

	private static void getUserWithArticles(UserDaoIface userIface) {
		Users users  = userIface.getUserWithArticle(1);
		System.out.println(users.getUser_name());
	}

	private static void contentAddressObject(UserDaoIface userIface) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_id" , 1) ;
		params.put("address_type" , 1) ;
		params.put("work_address_type" , 2) ;
		Users user = userIface.getUserWithAddress(1, 1, 2);
		System.out.println(user.getUserAddress().getAddressDetail() + " address Id :" + user.getUserAddress().getAddressId());
		System.out.println(user.getWorkAddress().getAddressType() + " work address Id :" + user.getWorkAddress().getAddressId());
		System.out.println(userIface.getAddressById(1).getAddressDetail());
		System.out.println("userName : " + user.getUser_name());
	}

	private static void insertList(UserDaoIface userIface) {
		List<Users> insertUsers = new ArrayList<Users>();
		for(int index = 0 ; index < 2 ; index++ ){
			Users temp = new Users();
			temp.setDepart("Java");
			temp.setSale(12);
			temp.setUser_age(1);
			temp.setUser_name("zhangrui");
			insertUsers.add(temp);
		}
		Map<String, Object> insertParams =new HashMap<String, Object>();
		insertParams.put("list", insertUsers);
		userIface.insertUserList(insertParams);
	}

	private static void insertSingleUser(UserDaoIface userIface) {
		Users temp = new Users();
		temp.setSale(67);
		temp.setUser_age(new Random().nextInt(10));
		temp.setUser_name("zhangsan" + new Random().nextInt(100));
		//temp.setDepart("JVA");
  		userIface.insertUserSingle(temp);
		System.out.println("Insert UserId : " + temp.getUser_id());
	}

	private static void mytipleSelect(UserDaoIface userIface) {
		Users user = new Users();
		user.setDepart("C#");
		user.setSale(5);
		System.out.println(userIface.mutipleSelect(user));
	}
}
