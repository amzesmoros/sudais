package com.pabwe;

import com.pabwe.storage.StorageProperties;
import com.pabwe.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SudaisApplication extends SpringBootServletInitializer {

    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(SudaisApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(SudaisApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//DEFAULT it was called, but I just disabled it
			//storageService.deleteAll();
			storageService.init();
		};
	}
}

