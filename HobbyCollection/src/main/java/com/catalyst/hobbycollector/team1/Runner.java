package com.catalyst.hobbycollector.team1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Runner for Spring Application
 * 
 * @author mhenry
 *
 */
@SpringBootApplication
public class Runner {
 
	/**
	 * use to fomat date
	 * @return
	 */
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
		b.indentOutput(true).simpleDateFormat("yyyy-MM-dd");
		return b;
	}
	
	/**
	 * used to run web app
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Runner.class);
	}

}