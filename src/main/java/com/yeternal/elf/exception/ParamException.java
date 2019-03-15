package com.yeternal.elf.exception;


import com.yeternal.elf.common.Status;

/**
 * <p>
 * 参数错误异常
 * </p>
 *
 * @package: com.yeternal.elf.exception
 * @description: 参数错误异常
 * @author: eternallove
 * @date: Created in 2018/11/30 13:25
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
public class ParamException extends BaseException {

    private final static Status DEFAULT_STATUS = Status.PARAM_NOT_NULL;

    public ParamException() {
        this(DEFAULT_STATUS);
    }

    public ParamException(Status status) {
        this(status, null);
    }

    public ParamException(Status status, String message) {
        this(status.getCode(), message, null);
    }

    public ParamException(Integer code, String message, Object data) {
        super(Status.OK.getCode(), code, message, data);
    }

}
