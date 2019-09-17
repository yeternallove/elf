package com.yeternal.elf.common.api;

import java.io.Serializable;


/**
 * <p>
 * 业务代码接口
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 13:49
 */
public interface IResultCode extends Serializable {

    /**
     * 消息
     *
     * @return String
     */
    String getReasonPhrase();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

}
