package com.spring.could.client1.feign;

import com.spring.could.client1.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date:2018/7/12
 * Author: yc.guo the one whom in nengxun
 * Desc:
 */

@FeignClient(name = "clilent-2",fallbackFactory = FeignfallbackFactory.class)
public interface FeignInterface {
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id);
}
