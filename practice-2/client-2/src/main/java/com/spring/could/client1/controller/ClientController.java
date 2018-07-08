package com.spring.could.client1.controller;

import com.netflix.appinfo.InstanceInfo;
import com.spring.could.client1.entity.User;
import com.spring.could.client1.mapper.UserMapper;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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
    private UserMapper userMapper;

    @Autowired
    private EurekaClient EurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/getServiceUrl/{name}")
    public String serviceUrl(@PathVariable("name") String name) {
        InstanceInfo instance = EurekaClient.getNextServerFromEureka(name, false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/getInstance/{name}")
    public String getInstance(@PathVariable("name") String name) {
        List<ServiceInstance> list = discoveryClient.getInstances(name);
        if (list != null && list.size() > 0 ) {
            return list.get(0).getHost().toString();
        }
        return null;
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") long id){
        User one = userMapper.getOne(id);
        System.out.println(one);
        return one;
    }
}
