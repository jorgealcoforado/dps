package com.dps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dps.enums.NewsEnum;
import com.dps.services.News;
import com.dps.services.impl.NewsApi;
import com.dps.services.impl.NewsData;

@Component
public class NewsConfig {

	@Autowired
	private NewsApi newsApi;
	
	@Autowired
	private NewsData newsData;
	
	public News getApi(NewsEnum api) {
		switch (api) {
			case NEWSAPI: {
				return newsApi;
			}
			case NEWSDATA: {
				return newsData;
			}
			default:
				return newsApi;
		}
	}
	
}
