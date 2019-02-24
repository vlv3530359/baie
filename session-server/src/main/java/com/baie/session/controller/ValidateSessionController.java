package com.baie.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * http://localhost:8081/session/get
 * check the session id, if it equals to http://localhost:8082/session/get
 */
@RestController
@RequestMapping("/session")
public class ValidateSessionController {

    /**
     * Check the session id is same in other module
     */
    @GetMapping("/get")
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

}
