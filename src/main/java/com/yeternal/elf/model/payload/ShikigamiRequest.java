package com.yeternal.elf.model.payload;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.dto
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 19:47
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
public class ShikigamiRequest {
    /**
     * 主键
     */
    private Long id;

    /**
     * 式神名
     */
    private String name;

    /**
     * 稀有度
     */
    private Integer rare;

    /**
     * 别称
     */
    private String alias;
}
