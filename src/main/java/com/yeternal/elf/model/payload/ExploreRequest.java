package com.yeternal.elf.model.payload;

import com.yeternal.elf.model.entity.Mapping;
import lombok.Data;

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
public class ExploreRequest {
    /**
     * 主键
     */
    private Long id;

    /**
     * 探索名称
     */
    private String name;

    /**
     * 关卡数
     */
    private Integer number;

    /**
     * 类型
     * {@link com.yeternal.elf.common.Constant#EXPLORE}:探索
     * {@link com.yeternal.elf.common.Constant#SEAL}:妖气封印
     * {@link com.yeternal.elf.common.Constant#SECRET}:秘闻
     * {@link com.yeternal.elf.common.Constant#NIGIMITAMA}:御魂
     */
    private String type;

    private List<Mapping> list;
}
