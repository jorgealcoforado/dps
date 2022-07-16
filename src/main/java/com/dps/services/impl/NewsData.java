package com.dps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dps.dto.response.NewsDataResponse;
import com.dps.dto.response.NewsResponse;
import com.dps.services.News;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	protected RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public NewsResponse getNews(String search) {
		String api = url.concat(basepath).concat(path).concat("?q=").concat(search).concat("&apiKey=").concat(apiKey);
		HttpHeaders headers = createHttpHeaders();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(api);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<NewsDataResponse> response =
				restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, NewsDataResponse.class);
		return mapper.convertValue(response.getBody(), NewsResponse.class);
	}
	
	private HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();   
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
