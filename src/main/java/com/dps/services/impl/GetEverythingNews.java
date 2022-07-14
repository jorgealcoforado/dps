package com.dps.services.impl;

import com.dps.services.News;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public class GetEverythingNews implements News {

	private String search;
	
	public GetEverythingNews(String search) {
		this.search = search;
	}
	
	@Override
	public void getNews() {
		
		newsApiClient.getEverything(
				  new EverythingRequest.Builder()
				          .q(search)
				          .build(),				          
				  new NewsApiClient.ArticlesResponseCallback() {
				      @Override
				      public void onSuccess(ArticleResponse response) {
				          System.out.println("GetEverythingNews: " + response.getArticles().get(0).getTitle());
				      }

				      @Override
				      public void onFailure(Throwable throwable) {
				          System.out.println(throwable.getMessage());
				      }
				  }
				);
	}

}
