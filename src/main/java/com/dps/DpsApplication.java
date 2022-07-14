package com.dps;

import com.dps.services.impl.GetEverythingNews;
import com.dps.services.impl.GetTopHeadlinesNews;
import com.dps.util.NewsUtil;

public class DpsApplication {

	public static void main(String[] args) {
		
		System.out.println("GetEverythingNews");
		NewsUtil.getNews(new GetEverythingNews("papa"));
		System.out.println("------------------");
		
		System.out.println("GetTopHeadlinesNews");
		NewsUtil.getNews(new GetTopHeadlinesNews("war"));
		System.out.println("------------------");
	}

}
