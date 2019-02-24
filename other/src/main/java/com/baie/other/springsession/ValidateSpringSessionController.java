package com.baie.other.springsession;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
@RequestMapping("session")
public class ValidateSpringSessionController {

    @GetMapping("/get")
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }
}
