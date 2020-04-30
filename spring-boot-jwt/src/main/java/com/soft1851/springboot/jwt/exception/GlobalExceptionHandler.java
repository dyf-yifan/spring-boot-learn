package com.soft1851.springboot.jwt.exception;

import com.soft1851.springboot.jwt.common.ResponseResult;
import com.soft1851.springboot.jwt.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月15日
 * @Version 1.0.0
 */
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    @ResponseBody
    public ResponseResult sendError(ArithmeticException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.ARITHMETICEXCEPTION_ERROR);
    }
    @ExceptionHandler(value = {JwtException.class})
    @ResponseBody
    public ResponseResult sendError(JwtException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(exception.getResultCode());
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public ResponseResult sendError(NullPointerException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

}