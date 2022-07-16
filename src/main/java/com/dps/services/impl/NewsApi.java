package com.dps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dps.dto.response.NewsResponse;
import com.dps.services.News;
import com.dps.util.NewsUtil;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

@Service
public class NewsApi implements News {

	@Value("${api.newsapi.url}")
	private String url;
	
	@Value("${api.newsapi.basepath}")
	private String basepath;
	
	@Value("${api.newsapi.path}")
	private String path;
	
	@Value("${api.newsapi.apiKey}")
	private String apiKey;
	
	@Autowired
	private NewsUtil newsUtil;
	
	@Override
	public NewsResponse getNews(String search) {
		return newsUtil.exchange(getUri(url, basepath, path, search, apiKey), ArticleResponse.class);
	}
	
}
