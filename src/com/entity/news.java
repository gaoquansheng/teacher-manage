package com.entity;

import java.util.Date;

public class news {
	private int news_id;
	private String news_title;
	private String news_content;
	private Date news_date;
	private String news_author;
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public Date getNews_date() {
		return news_date;
	}
	public void setNews_date(Date news_date) {
		this.news_date = news_date;
	}
	public String getNews_author() {
		return news_author;
	}
	public void setNews_author(String news_author) {
		this.news_author = news_author;
	}

}
