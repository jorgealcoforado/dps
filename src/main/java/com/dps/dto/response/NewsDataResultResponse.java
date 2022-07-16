package com.dps.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class NewsDataResultResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6660295673218510406L;
	
	private String title;
	private String link;
	private List<String> keywords;
	private List<String> creator;
	private String video_url;
	private String description;
	private String content;
	private String pubDate;
	private String image_url;
	private String source_id;
	
	private List<String> country;
	private List<String> category;
	private String language;
	
}
