package com.yeternal.elf.common.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 通用分页参数封装
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 13:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery {
    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String sortBy;

    /**
     * 排序方式，升序：ASC，降序：DESC
     */
    private String sortType;

    public <T> Page<T> page() {
        return new Page<>(getCurrentPage(), getPageSize());
    }
}
