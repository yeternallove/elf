package com.yeternal.elf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.mapper.MappingMapper;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.vo.MappingVO;
import com.yeternal.elf.service.MappingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.service.impl
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/18 11:05
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Service
public class MappingServiceImpl extends ServiceImpl<MappingMapper, Mapping> implements MappingService {


    @Override
    public List<MappingVO> listByExploreId(Long id) {
        return baseMapper.listByExploreId(id);
    }
}
