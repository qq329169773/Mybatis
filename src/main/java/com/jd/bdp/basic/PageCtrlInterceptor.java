package com.jd.bdp.basic;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

@Intercepts({@Signature(
		type=StatementHandler.class,
		method="prepare",
		args={Connection.class,Integer.class})
	})  
public class PageCtrlInterceptor implements Interceptor{

	 
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("Args...." + Arrays.toString(invocation.getArgs()) );
		System.out.println("Method : "+ invocation.getMethod());	
		System.out.println("TargetClass : "+ invocation.getTarget().getClass().getName());	
 		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		System.out.println("target Name : " + target.getClass().getName());
 		/*return  Plugin.wrap(target, this);*/
		return target ;
	}

	@Override
	public void setProperties(Properties properties) {
		System.out.println("here....");
	}

}
