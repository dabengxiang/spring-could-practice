package com.spring.could.ribbon;


import com.spring.could.ExcludeFromComponentScan;
import com.spring.could.ribbon.config.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLILENT-1",configuration = TestConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(ExcludeFromComponentScan.class)})
public class RibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
