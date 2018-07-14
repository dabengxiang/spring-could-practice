package com.spring.could.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.could.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Date:2018/7/8
 * Author:gyc
 * Desc:
 */

@RestController
@EnableCircuitBreaker
public class UserController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("getUser/{id}")
    @HystrixCommand(fallbackMethod = "getUserFallBack")
    public User getUser(@PathVariable("id") long id){
        return this.restTemplate.getForObject("http://CLILENT-1/getUser/" + id, User.class);
    }


    public  User getUserFallBack(long id){
        User user = new User();
        user.setName("fallback数据");
        return user;
    }






}
