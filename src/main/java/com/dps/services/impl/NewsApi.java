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

import com.dps.dto.response.NewsResponse;
import com.dps.services.News;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	protected RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public NewsResponse getNews(String search) {
		String api = url.concat(basepath).concat(path).concat("?q=").concat(search).concat("&apiKey=").concat(apiKey);
		HttpHeaders headers = createHttpHeaders();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(api);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<ArticleResponse> response =
				restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, ArticleResponse.class);
		return mapper.convertValue(response.getBody(), NewsResponse.class);
	}
	
	private HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();   
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
}
