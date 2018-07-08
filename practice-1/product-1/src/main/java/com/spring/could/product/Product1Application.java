package com.spring.could.product;

import com.spring.could.product.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Product1Application {
	public static void main(String[] args) {
		SpringApplication.run(Product1Application.class, args);
	}


}
