package com.dps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.dps.enums.NewsEnum;

@Component
public class AppStartupRunner implements ApplicationRunner {
   
	@Autowired
	private NewsConfig newsConfig;
	
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	newsConfig.getApi(NewsEnum.NEWSAPI).getNews("papa").getResults().forEach(System.out::println);
    }
}