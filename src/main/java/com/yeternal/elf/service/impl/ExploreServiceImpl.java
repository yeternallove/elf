package com.yeternal.elf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.common.api.PageResult;
import com.yeternal.elf.mapper.ExploreMapper;
import com.yeternal.elf.model.entity.Explore;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.payload.ExploreRequest;
import com.yeternal.elf.model.query.ExploreQuery;
import com.yeternal.elf.model.vo.ExploreVO;
import com.yeternal.elf.model.vo.MappingVO;
import com.yeternal.elf.service.ExploreService;
import com.yeternal.elf.service.MappingService;
import com.yeternal.elf.util.BeanConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    @Transactional(rollbackFor = Exception.class)
    public void updateMapping(Long id, List<Mapping> mappings) {
        Map<Boolean, List<Mapping>> collect = mappings.stream().collect(Collectors.partitioningBy(mapping -> Objects.isNull(mapping.getId()) || mapping.getId() == -1));
        mappingService.saveBatch(collect.get(true));
        mappingService.updateBatchById(collect.get(false));
    }

    @Override
    public ExploreVO getExplore(Long id) {
        List<MappingVO> mappings = mappingService.listByExploreId(id);
        return BeanConverter.toExploreVO(getById(id), mappings);
    }

    @Override
    public PageResult<Explore> listExplore(ExploreQuery exploreQuery) {
        IPage<Explore> page = page(exploreQuery.page());
        return PageResult.of(page.getTotal(), page.getRecords());
    }
}
