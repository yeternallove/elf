package com.yeternal.elf.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 统一分页返回结果封装
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 13:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页数据
     */
    private List<T> list;

    /**
     * 构造器
     *
     * @param total 总记录数
     * @param list  当前页数据
     */
    public PageResult(int total, List<T> list) {
        this.total = (long) total;
        this.list = list;
    }

    public static <T> PageResult<T> of(int total, List<T> list) {
        return new PageResult<>(total, list);
    }

    public static <T> PageResult<T> of(long total, List<T> list) {
        return new PageResult<>(total, list);
    }
}
