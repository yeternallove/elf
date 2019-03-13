package com.yeternal.elf.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.entity
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 18:42
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("elf_mapping")
public class Mapping implements Serializable {
    private static final long serialVersionUID = -4786884531631574897L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 式神id
     */
    private Long shikigamiId;

    /**
     * 探索id
     */
    private Long exploreId;

    /**
     * 备注
     */
    private String note;
}
