package com.spring.could.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;
import com.spring.could.ExcludeFromComponentScan;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date:2018/7/8
 * Author:gyc
 * Desc:
 */

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
/*    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }*/

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
