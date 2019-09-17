package com.yeternal.elf.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 基础异常
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:30
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private final Integer httpCode;
    private final Integer code;
    private final String message;
    private final Object data;

    public BaseException(Integer httpCode, Integer code, String message, Object data) {
        super(message);
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseException(Integer code, String message, Object data) {
        this(HttpServletResponse.SC_OK, code, message, data);
    }

}
