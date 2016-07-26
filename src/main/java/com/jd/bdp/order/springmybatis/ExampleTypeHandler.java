package com.jd.bdp.order.springmybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.StringTypeHandler;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(String.class)
public class ExampleTypeHandler extends BaseTypeHandler<String>{

	 @Override
	  public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		 System.out.println("set params :" + parameter  + " value : " + parameter);
 		 ps.setString(i, parameter);
 	  }

	  @Override
	  public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
			 System.out.println("get1");
 	    return null ;
	  }

	  @Override
	  public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
			 System.out.println("get2");
			  return null ;
	  }

	  @Override
	  public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
			 System.out.println("get3");

		  return null ;
	  }

}
