package com.jd.bdp.order.springmybatis;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Properties;

import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

@Intercepts({
	@Signature(type =  StatementHandler.class ,method = "prepare" , args = {Connection.class, Integer.class})
})
public class StatementHandlerIntercepts implements Interceptor {
	
  protected ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
  protected ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
  protected ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
  
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		  StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
	      MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,  
	      DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,reflectorFactory); 
	      System.out.println(metaStatementHandler);
 		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
 	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
