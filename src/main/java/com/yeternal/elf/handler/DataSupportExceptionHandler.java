package com.yeternal.elf.handler;

import cn.hutool.core.collection.CollUtil;
import com.yeternal.elf.common.ApiResponse;
import com.yeternal.elf.common.Status;
import com.yeternal.elf.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;


/**
 * <p>
 * 数据支撑平台统一异常处理
 * </p>
 *
 * @package: com.yeternal.elf.handler
 * @description: 数据支撑平台统一异常处理
 * @author: yangkai.shen
 * @date: Created in 2018/10/9 2:10 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@ControllerAdvice
@Slf4j
public class DataSupportExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse handlerException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            log.error("【全局异常拦截】NoHandlerFoundException: 请求方法 {}, 请求路径 {}", ((NoHandlerFoundException) e).getRequestURL(), ((NoHandlerFoundException) e).getHttpMethod());
            return ApiResponse.ofStatus(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            final MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) e;
            log.error("【全局异常拦截】MethodArgumentTypeMismatchException: 参数名 {}, 异常信息 {}", exception.getName(), exception.getMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_MATCH);
        } else if (e instanceof HttpMessageNotReadableException) {
            log.error("【全局异常拦截】HttpMessageNotReadableException: 错误信息 {}", ((HttpMessageNotReadableException) e).getHttpInputMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_NULL);
        } else if (e instanceof UnsatisfiedServletRequestParameterException) {
            log.error("【全局异常拦截】UnsatisfiedServletRequestParameterException: 错误信息 {}", e.getLocalizedMessage());
            return ApiResponse.ofStatus(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof ConstraintViolationException) {
            log.error("【全局异常拦截】ConstraintViolationException", e);
            return ApiResponse.of(Status.BAD_REQUEST.getCode(), CollUtil.getFirst(((ConstraintViolationException) e).getConstraintViolations()).getMessage(), null);
        } else if (e instanceof MethodArgumentNotValidException) {
            log.debug("【全局异常拦截】MethodArgumentNotValidException, {}", e.getLocalizedMessage());
            return ApiResponse.of(Status.BAD_REQUEST.getCode(), ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage(), null);
        } else if (e instanceof ParamException) {
            log.debug("【全局异常拦截】ParamException, {}", e.getLocalizedMessage());
            return ApiResponse.ofException((ParamException) e);
        }
        log.error("【全局异常拦截】: 异常信息 {}: {} ", e.getClass().getSimpleName(), e.getMessage());
        return ApiResponse.ofStatus(Status.UNKNOWN_ERROR);
    }
}
