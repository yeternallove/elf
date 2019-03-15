package com.yeternal.elf.model.query;

import com.yeternal.elf.common.PageCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.query
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 20:22
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShikigamiQuery extends PageCondition {
    /**
     * 式神名或别称
     */
    private String name;

    /**
     * 稀有度
     */
    private Integer rare;


}
