package com.dps.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NewsResponse {

	private String status;
    private int totalResults;
    
    @JsonProperty("results")
    @JsonAlias("articles")
    private List<NewsResultResponse> results;
}
