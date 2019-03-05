package com.yeternal.elf.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 * 分页参数
 * </p>
 *
 * @package: com.yeternal.elf.common
 * @description: 分页参数
 * @author: yangkai.shen
 * @date: Created in 2018/11/16 15:12
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@Data
public class PageCondition implements Serializable {
    private static final long serialVersionUID = -3594878986381392305L;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

    public Integer getCurrentPage() {
        if (Objects.isNull(currentPage)) {
            return Constant.DEFAULT_CURRENT;
        }
        return currentPage;
    }

    public Integer getPageSize() {
        if (Objects.isNull(pageSize)) {
            return Constant.DEFAULT_SIZE;
        }
        return pageSize;
    }
}
