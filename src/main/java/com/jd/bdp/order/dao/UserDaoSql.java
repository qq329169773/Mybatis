package com.jd.bdp.order.dao;

import org.apache.ibatis.jdbc.SQL;

public class UserDaoSql {

	public static void main(String[] args) {
		System.out.println(getUsersByPage());
	}
	public static String getUsersByPage(){
		return new SQL() {
			{
		    SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
		    FROM("PERSON P");
		    SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
		    FROM("PERSON P");
		  }
			
		}.toString();
	}
}
