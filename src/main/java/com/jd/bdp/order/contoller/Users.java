package com.jd.bdp.order.contoller;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class Users {

	/**
	 * 用户编号
	 */
	private Integer user_id;
	/**
	 * 用户名称
	 */
	private String user_name;
	/**
	 * 密码
	 */
	private int user_age;
	/**
	 * 生日
	 */
	private int sale;
	/**
	 * 邮箱
	 */
	private String depart;

	private String descr;

	private String email;

	private UserAddress userAddress;

	private UserAddress workAddress ;
	
	private List<Article> articles ;
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public UserAddress getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(UserAddress workAddress) {
		this.workAddress = workAddress;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
}
