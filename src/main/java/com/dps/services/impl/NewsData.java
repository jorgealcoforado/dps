package com.dps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dps.dto.response.NewsDataResponse;
import com.dps.dto.response.NewsResponse;
import com.dps.services.News;
import com.dps.util.NewsUtil;

@Service
public class NewsData implements News {

	@Value("${api.newsdata.url}")
	private String url;
	
	@Value("${api.newsdata.basepath}")
	private String basepath;
	
	@Value("${api.newsdata.path}")
	private String path;
	
	@Value("${api.newsdata.apiKey}")
	private String apiKey;
	
	@Autowired
	private NewsUtil newsUtil;
	
	@Override
	public NewsResponse getNews(String search) {
		return newsUtil.exchange(getUri(url, basepath, path, search, apiKey), NewsDataResponse.class);
	}
	
}
