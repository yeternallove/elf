package com.yeternal.elf.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @package: com.yeternal.elf.exception
 * @description:
 * @author: eternallove
 * @date: Created in 2018/11/16 13:46
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {
    private Integer httpCode;
    private Integer code;
    private String message;
    private Object data;

    public BaseException(Integer httpCode, Integer code, String message, Object data) {
        super(message);
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
