package com.baie.other.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomizedException extends RuntimeException
{
    public CustomizedException(String exception) {
        super("user not found");
    }
}
