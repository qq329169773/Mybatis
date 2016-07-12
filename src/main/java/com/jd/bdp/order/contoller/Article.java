package com.jd.bdp.order.contoller;

import org.apache.ibatis.type.Alias;

@Alias("article")
public class Article {

	private Integer userId ;
	private Integer articleId ;
	private String articleTitle ;
	private String articleName ;
	private String articleDesc ;
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleDesc() {
		return articleDesc;
	}
	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
