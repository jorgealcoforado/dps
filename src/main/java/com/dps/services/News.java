package com.dps.services;

import com.kwabenaberko.newsapilib.NewsApiClient;

public interface News {
	
	NewsApiClient newsApiClient = new NewsApiClient("8fb7b8404e0e4a97a4e112452119447e");
	
	void getNews();
}
