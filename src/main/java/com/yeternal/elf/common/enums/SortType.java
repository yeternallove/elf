package com.yeternal.elf.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 排序方式
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 13:58
 */
@Getter
@AllArgsConstructor
public enum SortType {
    /**
     * 升序
     */
    ASC("ASC"),
    /**
     * 降序
     */
    DESC("DESC");

    private String type;
}
