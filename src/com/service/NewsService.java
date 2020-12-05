package com.service;

import java.util.List;

import com.entity.news;

public interface NewsService {

	void add_news(news add_news);

	List<news> L_news();

	void delete_news(news delete_news);

	void update_news(news up_news);

	List<news> find_news(news news_id);

}
