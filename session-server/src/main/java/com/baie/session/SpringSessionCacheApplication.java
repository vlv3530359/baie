package com.baie.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SpringSessionCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSessionCacheApplication.class, args);
	}

}

