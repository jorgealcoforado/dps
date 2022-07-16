package com.dps.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class NewsDataResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2534847243814639315L;
	
	private String status;
    private int totalResults;
    private List<NewsDataResultResponse> results;
}
