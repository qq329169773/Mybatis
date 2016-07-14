package com.jd.bdp.order.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import com.jd.bdp.order.contoller.UserAddress;
import com.jd.bdp.order.contoller.Users;

public interface UserDaoIface {
	
 	public Users selectUserByID(int id);
	
	public List<Users> mutipleSelect(Users users);
	
	public void insertUserList(Map<String, Object>  insertParams) ;

	public void insertUserSingle(Users user );

 //	public Users getUserWithAddress(Map<String, Object> params) ;
	
	public Users getUserWithAddress(@Param("user_id") int user_id , 
			@Param("address_type") int address_type ,
			@Param("work_address_type") int work_address_type) ;
	
	
	public Users getUserWithArticle(@Param("user_id") int user_id) ;
	
	
	public List<Users> getUserBySaleDepart(@Param("sale") int sale , @Param("depart") String depart);
	
	
	public int updateUsers(@Param("user_id") int userId , @Param("user")  Users users) ;
	
 	public UserAddress getAddressById(int address_id);
 	
 	@Select("select * from user_address where address_id = #{address_id}")
 	public UserAddress getAddressByIdSpring(@Param("address_id") int address_id);
 	
 	@Select("select * from users where user_id = #{user_id}")
 	public Users getUserByIdSpring(@Param("user_id") int user_id);
 	 
}


