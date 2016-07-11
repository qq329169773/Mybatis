package com.jd.bdp.order.mybatis;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class ExampleObjectFactory extends DefaultObjectFactory {

	@Override
	public <T> T create(Class<T> type) {
		 
  		return super.create(type);
	}

}