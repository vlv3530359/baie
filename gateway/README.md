1. How to include Spring Cloud Gateway


dependencies {
    implementation "org.springframework.cloud:spring-cloud-starter-gateway" it's conflict with org.springframework.cloud:spring-cloud-starter-netflix-eureka-server 
    implementation "org.springframework.cloud:spring-cloud-starter-netflix-hystrix" it's for the hystrix
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

If you include the starter, but, for some reason, you do not want the gateway to be enabled, set spring.cloud.gateway.enabled=false.


2. application.properties
spring:
  application:
    name: gateway-server
  cloud:
    config:
      label: 1003
      profile: dev
      url: http://localhost:8888/
    gateway:
      routes:
      - id: apiproduct
        # 重点！/info必须使用http进行转发，lb代表从注册中心获取服务
        uri: lb://product
        predicates:
        # 重点！转发该路径！,/userapi/**,
        - Path=/apiproduct/**
        # http://localhost:6601/userapi/user/users/2, 必须加上StripPrefix=1，否则访问服务时会带上userapi
        #而不是我们期望的去掉userapi，只保留**部分
        filters:
        - StripPrefix=1
        # 限流
        - name: RequestRateLimiter
          args:
            redis-rate-limiter.replenishRate: 10
            redis-rate-limiter.burstCapacity: 20
            key-resolver: '#{@hostAddrKeyResolver}'
        # For hystrix
        - name: Hystrix
          args:
            name: fallbackcmd
            fallbackUri: forward:/fallback

# For hystrix
hystrix.command.fallbackcmd.execution.isolation.thread.timeoutInMilliseconds: 5000



