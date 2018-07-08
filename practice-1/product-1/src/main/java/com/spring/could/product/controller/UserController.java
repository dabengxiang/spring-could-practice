package com.spring.could.product.controller;

import com.spring.could.product.entity.User;
import com.spring.could.product.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2018/7/7
 * Author:gyc
 * Desc:
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUser (@PathVariable("id")Long id){
        return userMapper.getOne(id);
    }

}
