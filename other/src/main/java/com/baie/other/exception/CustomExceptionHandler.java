package com.baie.other.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{

//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse("Server Error", details);
//        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(CustomizedException.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    public Map<String, Object> handleUserNotFoundException(CustomizedException ex) {
        Map<String,Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("type", "CustomizedException");
        return result;
    }


}
