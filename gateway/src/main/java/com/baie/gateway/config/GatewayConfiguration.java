package com.baie.gateway.config;

import com.baie.gateway.keyresolver.ApiKeyResolver;
import com.baie.gateway.keyresolver.HostAddrKeyResolver;
import com.baie.gateway.keyresolver.UserKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean(name="hostAddrKeyResolver")
    public HostAddrKeyResolver getHostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

//    @Bean(name="userKeyResolver")
//    public UserKeyResolver getUserKeyResolver() {
//        return new UserKeyResolver();
//    }
//
//    @Bean(name="apiKeyResolver")
//    public ApiKeyResolver getApiKeyResolver() {
//        return new ApiKeyResolver();
//    }
}
