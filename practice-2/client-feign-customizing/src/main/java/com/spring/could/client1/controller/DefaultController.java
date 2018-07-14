package com.spring.could.client1.controller;

import com.spring.could.client1.entity.User;
import com.spring.could.client1.feign.DefaultFeignInterface;
import com.spring.could.client1.feign.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2018/7/8
 * Author:gyc
 * Desc:
 */
@RestController
public class DefaultController {
    @Autowired
    private DefaultFeignInterface defaultFeignInterface;
    @GetMapping("/getDefaultUser/{id}")
    public User getFeign(@PathVariable("id")Long id){
        return defaultFeignInterface.getUser(id);
    }
}
