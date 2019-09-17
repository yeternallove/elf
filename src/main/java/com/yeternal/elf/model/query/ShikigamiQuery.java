package com.yeternal.elf.model.query;

import com.yeternal.elf.common.api.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 式神查询
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShikigamiQuery extends PageQuery {
    /**
     * 式神名或别称
     */
    private String name;

    /**
     * 稀有度
     */
    private Integer rare;


}
