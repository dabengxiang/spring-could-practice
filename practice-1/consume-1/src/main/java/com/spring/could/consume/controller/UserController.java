package com.spring.could.consume.controller;

import com.spring.could.consume.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Date:2018/7/7
 * Author:gyc
 * Desc:
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id ){
        System.out.println(userServicePath+id);
//        User user = restTemplate.getForObject(userServicePath + id, User.class);
       User user = restTemplate.getForObject("http://CLILENT-1/getUser/" + id, User.class);
        return user;
    }
}
