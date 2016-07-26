package com.jd.bdp.order.springmybatis;

import java.util.Arrays;
import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts(
		{
		@Signature(type = Executor.class, 
		method = "query", 
		args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}), 
		@Signature(type = Executor.class, 
		method = "query", 
		args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}) 
		})
public class ExampleIntercepts implements Interceptor {
	
	public Object intercept(Invocation invocation) throws Throwable {
		if(invocation.getTarget() instanceof CachingExecutor){
			CachingExecutor executor = (CachingExecutor)invocation.getTarget();
 		}
		MappedStatement maeppedStatement = (MappedStatement)invocation.getArgs()[0];
		BoundSql boundSql = maeppedStatement.getBoundSql(null);
  		System.out.println("do intercept ...." + boundSql.getSql().toString());
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}