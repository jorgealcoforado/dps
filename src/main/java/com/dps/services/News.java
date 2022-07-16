package com.dps.services;

import org.springframework.stereotype.Component;

import com.dps.dto.response.NewsResponse;

@Component
public interface News {
	
	NewsResponse getNews(String search);
}
