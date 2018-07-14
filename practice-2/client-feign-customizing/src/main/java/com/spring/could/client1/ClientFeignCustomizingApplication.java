package com.spring.could.client1;

import com.spring.could.client1.config.ExcludeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeConfiguration.class)})
public class ClientFeignCustomizingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientFeignCustomizingApplication.class, args);
	}
}
