package com.spring.could.client1.feign;

import com.spring.could.client1.config.AuthConfiguration;
import com.spring.could.client1.config.DefaultConfiguration;
import com.spring.could.client1.config.ExcludeConfiguration;
import com.spring.could.client1.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date:2018/7/12
 * Author: yc.guo the one whom in nengxun
 * Desc:
 */

@FeignClient(value = "CLILENT-1",configuration = DefaultConfiguration.class)
public interface DefaultFeignInterface {
    @RequestLine("GET /getUser/{id}")
    public User getUser(@Param("id") Long id);


}
