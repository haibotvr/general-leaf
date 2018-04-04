package com.maihb.general.framework.exception;

import com.maihb.general.framework.web.ReturnValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnValue handleException(Exception e){
        log.error("捕获Controller异常:", e);
        return ReturnValue.error().setMessage(e.getMessage());
    }

}
