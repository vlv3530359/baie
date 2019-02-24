package com.baie.other.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/notfound")
    public String notFound() {
        throw new CustomizedException("not found");
    }
}
