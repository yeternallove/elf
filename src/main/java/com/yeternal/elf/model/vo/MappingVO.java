package com.yeternal.elf.model.vo;

import com.yeternal.elf.model.entity.Mapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.vo
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/19 20:42
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MappingVO extends Mapping {

    /**
     * 式神名
     */
    private String name;
}
