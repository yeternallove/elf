package com.yeternal.elf.model.dto;

import com.yeternal.elf.model.entity.Explore;
import com.yeternal.elf.model.entity.Mapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

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
@EqualsAndHashCode(callSuper = true)
public class ExploreDTO extends Explore {
    private List<Mapping> list;
}
