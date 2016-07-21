package com.jd.bdp.basic;

import java.util.List;

public class PageCtrl<T> {

	public List<T> datas ;
	
	public int totalPage ;		//总页数
	public int totalSize ;		//总条数d 的
 	public int pageSize ;		//每页多少条
	public int pageNo ;			//请求第几页
	
	
	public static void main(String[] args) {
		PageCtrl<String> p = new PageCtrl<String>();
		PageCtrl<String> p1 = new PageCtrl<String>();
 
	}
}
