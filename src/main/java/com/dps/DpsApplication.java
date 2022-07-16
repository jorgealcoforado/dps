package com.dps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ComponentScan("com.dps")
public class DpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpsApplication.class, args);
	}
		
	@EventListener(ContextRefreshedEvent.class)
	void started() {
//		System.out.println("GetEverythingNews");
//		NewsUtil.getNews(new GetEverythingNews("papa"));
//		System.out.println("------------------");
	}

}
