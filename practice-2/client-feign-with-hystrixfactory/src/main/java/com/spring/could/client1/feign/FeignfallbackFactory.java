package com.spring.could.client1.feign;

import com.spring.could.client1.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Date:2018/7/14
 * Author:gyc
 * Desc:
 */

@Component
public class FeignfallbackFactory implements FallbackFactory<FeignInterface>{
    public static final Logger LOGGER = LoggerFactory.getLogger(FeignfallbackFactory.class);

    @Override
    public FeignInterface create(Throwable throwable) {
        FeignfallbackFactory.LOGGER.info("fallback; reason was: {}", throwable.getMessage());

        return new FeignInterface() {
            @Override
            public User getUser(Long id) {
                User user = new User();
                user.setId(0L);
                return user;
            }
        };
    }
}
