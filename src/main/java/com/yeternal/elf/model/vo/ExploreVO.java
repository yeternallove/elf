package com.yeternal.elf.model.vo;

import com.yeternal.elf.model.entity.Explore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.vo
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 20:17
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExploreVO extends Explore {

    List<MappingVO> mappingList;
}
