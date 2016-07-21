package com.jd.bdp.order.springmybatis;

import java.util.Arrays;
import java.util.Properties;

import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts(
		{@Signature(type = Executor.class, 
		method = "update", 
		args = { MappedStatement.class, Object.class }) })
public class ExampleIntercepts implements Interceptor {
	
	public Object intercept(Invocation invocation) throws Throwable {
		if(invocation.getTarget() instanceof CachingExecutor){
			CachingExecutor executor = (CachingExecutor)invocation.getTarget();
 		}
		MappedStatement maeppedStatement = (MappedStatement)invocation.getArgs()[0];
  		System.out.println(Arrays.toString(invocation.getArgs()));
 		System.out.println("do intercept ....");
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}