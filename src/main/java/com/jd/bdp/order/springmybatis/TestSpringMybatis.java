package com.jd.bdp.order.springmybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.parsing.PropertyParser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.JdbcType;


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
  		Executor s ;
  		Blog object = sqlSession.selectOne("com.jd.bdp.order.springmybatis.BlogDaoInterface.selectBlog","updateTitle2");
   		System.out.println(object);
  	/*	BlogDaoInterface blogDao = sqlSession.getMapper(BlogDaoInterface.class);
  		Blog blog = new Blog();
  		blog.setContent("lisi nihao");
  		blog.setTitle("lisi Title");
  		blog.setUser("lisi");
		blogDao.insertBlog(blog );
		System.out.println(blog.getId());
		sqlSession.commit();*/
	}
}
