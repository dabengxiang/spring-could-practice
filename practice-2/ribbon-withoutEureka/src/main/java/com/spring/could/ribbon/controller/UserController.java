package com.spring.could.ribbon.controller;

import com.spring.could.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable("id") long id){
        return this.restTemplate.getForObject("http://CLILENT-1/getUser/" + id, User.class);
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance instance = loadBalancerClient.choose("CLILENT-1");
        URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        System.out.println(String.format("CLILENT-1---:"+"http://%s:%s", instance.getHost(), instance.getPort()));
        instance = loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER");
        System.out.println(String.format("MICROSERVICE-PROVIDER-USER---:"+"http://%s:%s", instance.getHost(), instance.getPort()));
        return "1";
    }


}
