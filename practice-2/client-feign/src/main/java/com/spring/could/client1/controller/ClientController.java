package com.spring.could.client1.controller;

import com.netflix.appinfo.InstanceInfo;
import com.spring.could.client1.entity.User;
import com.spring.could.client1.feign.FeignInterface;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2018/7/8
 * Author:gyc
 * Desc:
 */
@RestController
public class ClientController {
    @Autowired
    private FeignInterface feignInterface;
    @GetMapping("/getFeign/{id}")
    public User getFeign(@PathVariable("id")long id){
        return feignInterface.getUser(id);
    }
}
