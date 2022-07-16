package com.dps.services;

import org.springframework.stereotype.Component;

@Component
public interface News {
	
	void getNews(String search);
}
