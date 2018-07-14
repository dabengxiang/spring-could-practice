package com.spring.could.client1.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date:2018/7/12
 * Author: yc.guo the one whom in nengxun
 * Desc:
 */
@Configuration
@ExcludeConfiguration
public class DefaultConfiguration {

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
