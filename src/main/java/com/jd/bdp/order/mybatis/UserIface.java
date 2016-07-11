package com.jd.bdp.order.mybatis;

import java.util.List;
import java.util.Map;

import com.jd.bdp.order.contoller.Users;

public interface UserIface {

	public Users selectUserByID(int id);
	
	public List<Users> mutipleSelect(Users users);
	
	public void insertUserList(Map<String, Object>  insertParams) ;

	public void insertUserSingle(Users user );
}


