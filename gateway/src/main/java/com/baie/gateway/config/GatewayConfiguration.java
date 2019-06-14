package com.baie.gateway.config;

import com.baie.gateway.keyresolver.ApiKeyResolver;
import com.baie.gateway.keyresolver.HostAddrKeyResolver;
import com.baie.gateway.keyresolver.UserKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Arrays;

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

    @Bean
    /**
     * Have to config this bean else get cors error, refer to Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource. Origin 'http://localhost:63342' is therefore not allowed access.
     * addtionally, need to sepcify corsConfiguration.setAllowCredentials(true);
     */
    public CorsWebFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsWebFilter(source);
    }

    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //在生产环境上最好指定域名，以免产生跨域安全问题
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
}
