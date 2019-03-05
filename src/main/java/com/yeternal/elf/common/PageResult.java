package com.yeternal.elf.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 分页数据返回格式封装
 * </p>
 *
 * @package: com.yeternal.elf.common
 * @description: 分页数据返回格式封装
 * @author: yangkai.shen
 * @date: Created in 2018/11/16 14:44
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 2061510924840623042L;

    private Long total;
    private List<T> data;

    public static <T> PageResult<T> of(Long total, List<T> data) {
        return new PageResult<>(total, data);
    }

    public static <T> PageResult<T> of(Integer total, List<T> data) {
        return new PageResult<>((long) total, data);
    }
}
