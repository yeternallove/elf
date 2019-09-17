package com.yeternal.elf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.vo.MappingVO;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.service
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/18 11:05
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
public interface MappingService extends IService<Mapping> {

    /**
     * 通过探索id查询列表
     *
     * @param id 探索id
     * @return {@link MappingVO}
     */
    List<MappingVO> listByExploreId(Long id);
}
