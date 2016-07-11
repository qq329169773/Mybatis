package com.jd.bdp.order.mybatis;

import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jd.bdp.order.contoller.Users;

public class TestMyBatis {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
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
			/*Object o = session.selectList("com.jd.bdp.order.mybatis.UserIface.selectAllUsers");
 			System.out.println(o);
			Users user = (Users) session.selectOne("com.jd.bdp.order.mybatis.UserIface.selectUserByID", 1);*/
			UserIface iface  = session.getMapper(UserIface.class);
			 
			/*HashMap<String,Object>  param = new HashMap<String,Object>();
			param.put("user_id", "1");
			param.put("depart", "java");
			System.out.println(iface.selectUserByIdAndDepart(param));*/
		/*	HashMap<String,Object>  param = new HashMap<String,Object>();
			param.put("user_name", "zhangsan");
			param.put("user_age", "9");
			Object o = session.selectOne("com.jd.bdp.order.mybatis.UserIface.selectUserByAge",param);
			System.out.println(o );*/
			testInsert(session);
		} finally {
			session.close();
		}
	}
	private static void testInsert(SqlSession session ){
		Users users = new Users();
		users.setDepart("C#");
		users.setSale(12);
		users.setUser_age(1);
		users.setUser_name("liuxinya");
		int count = session.insert("com.jd.bdp.order.mybatis.UserIface.insertMutipleUser",Arrays.asList(users,users) );
		System.out.println(count   + "  : " + users.getUser_id());
		session.commit();
	}
}
