package com.yeternal.elf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.mapper.ExploreMapper;
import com.yeternal.elf.model.entity.Explore;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.payload.ExploreRequest;
import com.yeternal.elf.model.query.ExploreQuery;
import com.yeternal.elf.model.vo.ExploreVO;
import com.yeternal.elf.service.ExploreService;
import com.yeternal.elf.service.MappingService;
import com.yeternal.elf.util.BeanConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.service.impl
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 18:46
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Service
@AllArgsConstructor
public class ExploreServiceImpl extends ServiceImpl<ExploreMapper, Explore> implements ExploreService {

    private final MappingService mappingService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ExploreRequest exploreDTO) {
        save(BeanConverter.toExplore(exploreDTO));
        mappingService.saveBatch(exploreDTO.getList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        removeById(id);
        QueryWrapper<Mapping> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Mapping::getExploreId, id);
        mappingService.remove(wrapper);
    }

    @Override
    public void update(Long id, ExploreRequest exploreDTO) {
        updateById(BeanConverter.toExplore(exploreDTO));
    }

    @Override
    public ExploreVO getExplore(Long id) {
        return BeanConverter.toExploreVO(getById(id));
    }

    @Override
    public PageResult<ExploreVO> listExplore(ExploreQuery exploreQuery) {
        List<ExploreVO> list = page(exploreQuery.page()).getRecords().stream().map(BeanConverter::toExploreVO).collect(Collectors.toList());
        return PageResult.of(count(), list);
    }
}
