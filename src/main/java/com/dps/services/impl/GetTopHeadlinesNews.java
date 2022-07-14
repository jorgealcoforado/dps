package com.dps.services.impl;

import com.dps.services.News;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public class GetTopHeadlinesNews implements News {

	private String search;
	
	public GetTopHeadlinesNews(String search) {
		this.search = search;
	}
	
	@Override
	public void getNews() {
		
		newsApiClient.getTopHeadlines(
				  new TopHeadlinesRequest.Builder()
				    .q(search)
				    .language("en")
				    .build(),
				  new NewsApiClient.ArticlesResponseCallback() {
				    @Override
				    public void onSuccess(ArticleResponse response) {
				      System.out.println("GetTopHeadlinesNews:" + response.getArticles().get(0).getTitle());
				    }

				    @Override
				    public void onFailure(Throwable throwable) {
				      System.out.println(throwable.getMessage());
				    }
				  }
				);
	}

}
