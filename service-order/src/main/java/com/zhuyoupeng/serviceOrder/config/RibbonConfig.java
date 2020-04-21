package com.zhuyoupeng.serviceOrder.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RibbonConfig {
    /**
     * RestTemplate 发送请求
     * loadBanlanced 注解可以实现负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 指定负载均衡算法
     * RoundRobinRule 轮询
     * RandomRule 随机
     * @return
     */
    public IRule iRule(){
        return new RandomRule();
}
}
