package com.spring.could.client1.feign;

import com.spring.could.client1.entity.User;
import org.springframework.stereotype.Component;

/**
 * Date:2018/7/14
 * Author:gyc
 * Desc:
 */

@Component
public class FeignFallback implements FeignInterface {
    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setName("fallback的名字");
        return user;
    }
}
