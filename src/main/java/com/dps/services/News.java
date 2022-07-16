package com.dps.services;

import com.dps.dto.response.NewsResponse;

public interface News {
	
	NewsResponse getNews(String search);
	
	public default String getUri(String url, String basepath, String path, String search, String apiKey) {
		return url.concat(basepath).concat(path).concat("?q=").concat(search).concat("&apiKey=").concat(apiKey);
	}
}
