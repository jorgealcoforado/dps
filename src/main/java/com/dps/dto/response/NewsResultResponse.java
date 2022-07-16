package com.dps.dto.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NewsResultResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6660295673218510406L;
	
	private String title;
	
	@JsonProperty("link")
    @JsonAlias("url")
	private String link;
	
	private List<String> keywords;
	private String author;
	private List<String> creator;
	private String video_url;
	private String description;
	private String content;
	
	@JsonProperty("pubDate")
    @JsonAlias("publishedAt")
	private String pubDate;
	
	@JsonProperty("image_url")
    @JsonAlias("urlToImage")
	private String image_url;
	private String source_id;
	
	private List<String> country;
	private List<String> category;
	private String language;
	
}
