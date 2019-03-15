package com.yeternal.elf.exception;

import com.yeternal.elf.common.Status;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.exception
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/14 17:33
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
public class ElfException extends BaseException {

    public ElfException(Status status) {
        super(Status.OK.getCode(), status.getCode(), status.getReasonPhrase(), null);
    }
}
