package com.dps.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dps.dto.response.NewsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class NewsUtil {

	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	public <T> NewsResponse exchange(String uri, Class<T> classe) {
		HttpHeaders headers = createHttpHeaders();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<T> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, classe);
		return mapper.convertValue(response.getBody(), NewsResponse.class);
	}
	
	private HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();   
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
