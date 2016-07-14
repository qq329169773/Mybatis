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

public interface CopyOfUserDaoIface { 
	public void save();
}


