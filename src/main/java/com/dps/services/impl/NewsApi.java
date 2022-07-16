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

import com.dps.enums.NewsEnum;
import com.dps.services.News;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
@NoArgsConstructor
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
	
	@Override
	public void getNews(String search) {
		String api = String.format(getApi(), search);
		HttpHeaders headers = createHttpHeaders();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(api);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<ArticleResponse> response =
				restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, ArticleResponse.class);
		response.getBody().getArticles().forEach(System.out::println);
	}
	
	private HttpHeaders createHttpHeaders() {
	    HttpHeaders headers = new HttpHeaders();   
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return headers;
	  }
	
	private String getApi() {
		return "https://newsapi.org/v2/everything?q=%s&apiKey=8fb7b8404e0e4a97a4e112452119447e";
	}

}
