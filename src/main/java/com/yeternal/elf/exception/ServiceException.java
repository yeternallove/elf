package com.yeternal.elf.exception;

import com.yeternal.elf.common.api.IResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 基础异常
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends BaseException {

    private final IResultCode resultCode;

    private final Object data;

    public ServiceException(IResultCode status) {
        super(status.getCode(), status.getReasonPhrase(), null);
        this.resultCode = status;
        this.data = null;
    }
}
