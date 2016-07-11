package com.jd.bdp.order.mybatis;

 
 
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.jd.bdp.order.contoller.Users;

public interface UserIface {

	public Users selectUserByID(int id);
	
 	public List<Users> selectAllUsers();
	
	public List<Users> selectUserName(String userName);
	
	@Select("select user_id from users where depart =#{depart}")
 	public List<Users> selectUserByDepartment(String depart);
	
	@Select("select user_id from users where  user_id = #{user_id} and  depart =#{depart}")
	public Users selectUserByIdAndDepart(Map<String, Object> hashMap) ;
	
	 
 	public Users selectUserByAge(Map<String, Object> hashMap) ;
	
 	public List<Users> mutipleSelect(Users users);
	
	public void insertUserList(Map<String, Object>  insertParams) ;

	public void insertUserSingle(Users user );

}


