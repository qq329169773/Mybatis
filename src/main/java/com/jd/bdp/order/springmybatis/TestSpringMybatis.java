package com.jd.bdp.order.springmybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class TestSpringMybatis {

	static SqlSessionFactory sqlSessionFactory ;
	static{
		String resource = "com/jd/bdp/order/springmybatis/mybatis-configration.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		} catch (IOException e) {
 			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
  		SqlSession sqlSession  = sqlSessionFactory.openSession();
  		Blog object = sqlSession.selectOne("org.mybatis.example.BlogMapper.selectBlog","title");
  		System.out.println(object.getContent());
 	}
}
