package com.jd.bdp.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.jd.bdp.basic.PageCtrl;
import com.jd.bdp.order.model.User;

public interface UserDaoIface {

	@SelectProvider(type = UserDaoSql.class , method = "getUsersByPage")
	public PageCtrl<User> getUsersByPage(PageCtrl<User> pageCtrl);
	
	public List<User> getUsers() ;
	
	public Integer insertUserSingle(User user) ;
}
