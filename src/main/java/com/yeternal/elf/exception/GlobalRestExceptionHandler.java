package com.yeternal.elf.exception;

import com.yeternal.elf.common.api.CommonResultCode;
import com.yeternal.elf.common.api.R;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.Servlet;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * <p>
 * 全局异常处理，处理可预见的异常
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:27
 */
@Slf4j
@Configuration
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R handleError(MissingServletRequestParameterException e) {
        log.warn("缺少请求参数，{}", e.getMessage());
        String message = String.format("缺少必要的请求参数: %s", e.getParameterName());
        return R.fail(CommonResultCode.PARAM_MISS, message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public R handleError(MethodArgumentTypeMismatchException e) {
        log.warn("请求参数格式错误，{}", e.getMessage());
        String message = String.format("请求参数格式错误: %s", e.getName());
        return R.fail(CommonResultCode.PARAM_TYPE_ERROR, message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleError(MethodArgumentNotValidException e) {
        log.warn("参数验证失败，{}", e.getMessage());
        return handleError(e.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    public R handleError(BindException e) {
        log.warn("参数绑定失败，{}", e.getMessage());
        return handleError(e.getBindingResult());
    }

    private R handleError(BindingResult result) {
        FieldError error = result.getFieldError();
        String message;
        if (null == error) {
            return R.fail(CommonResultCode.PARAM_BIND_ERROR);
        } else {
            message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
            return R.fail(CommonResultCode.PARAM_BIND_ERROR, error.getDefaultMessage(), message);
        }
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public R handleError(ConstraintViolationException e) {
        log.warn("参数验证失败，{}", e.getMessage());
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
        String message = String.format("%s:%s", path, violation.getMessage());
        return R.fail(CommonResultCode.PARAM_VALID_ERROR, message);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public R handleError(NoHandlerFoundException e) {
        log.error("404没找到请求，{}", e.getMessage());
        return R.fail(CommonResultCode.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R handleError(HttpMessageNotReadableException e) {
        log.error("消息不能读取，{}", e.getMessage());
        return R.fail(CommonResultCode.MSG_NOT_READABLE, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R handleError(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法，{}", e.getMessage());
        return R.fail(CommonResultCode.METHOD_NOT_SUPPORTED, e.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public R handleError(HttpMediaTypeNotSupportedException e) {
        log.error("不支持当前媒体类型，{}", e.getMessage());
        return R.fail(CommonResultCode.MEDIA_TYPE_NOT_SUPPORTED, e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public R handleError(ServiceException e) {
        log.error("业务异常({}):{}", e.getResultCode(), e.getMessage());
        return R.fail(e.getResultCode(), e.getMessage(), e.getData());
    }

    @ExceptionHandler(Throwable.class)
    public R handleError(Throwable e) {
        log.error("服务器异常", e);
        return R.fail(CommonResultCode.INTERNAL_SERVER_ERROR, (ObjectUtils.isEmpty(e.getMessage()) ? CommonResultCode.INTERNAL_SERVER_ERROR.getReasonPhrase() : e.getMessage()));
    }

}
