package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.news;
import com.mapper.NewsMapper;
import com.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsMapper newsMapper;
	
	@Override
	public void add_news(news add_news) {
		// TODO Auto-generated method stub
		newsMapper.add_news(add_news);
	}

	@Override
	public List<news> L_news() {
		// TODO Auto-generated method stub
		return newsMapper.L_news();
	}

	@Override
	public void delete_news(news delete_news) {
		// TODO Auto-generated method stub
		newsMapper.delete_news(delete_news);
	}

	@Override
	public void update_news(news up_news) {
		// TODO Auto-generated method stub
		newsMapper.update_news(up_news);
	}

	@Override
	public List<news> find_news(news news_id) {
		// TODO Auto-generated method stub
		return newsMapper.find_news(news_id);
	}



}
