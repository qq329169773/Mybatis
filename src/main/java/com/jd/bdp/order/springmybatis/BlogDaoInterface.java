package com.jd.bdp.order.springmybatis;

import org.apache.ibatis.annotations.Param;


 
public interface BlogDaoInterface {

	public Blog selectBlog(@Param("title") String title) ;
	
	public Integer updateBlog(Blog blog) ;
	
	public void insertBlog(Blog blog) ;
	
}
