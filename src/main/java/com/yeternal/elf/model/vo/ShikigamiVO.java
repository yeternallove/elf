package com.yeternal.elf.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.vo
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 20:22
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
public class ShikigamiVO {
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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上次更新时间
     */
    private Date lastUpdateTime;
}
