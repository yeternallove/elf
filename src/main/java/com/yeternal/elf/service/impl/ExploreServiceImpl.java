package com.yeternal.elf.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.mapper.ExploreMapper;
import com.yeternal.elf.model.dto.ExploreDTO;
import com.yeternal.elf.model.entity.Explore;
import com.yeternal.elf.model.query.ExploreQuery;
import com.yeternal.elf.model.vo.ExploreVO;
import com.yeternal.elf.service.ExploreService;
import com.yeternal.elf.util.BeanConverter;
import org.springframework.stereotype.Service;

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
public class ExploreServiceImpl extends ServiceImpl<ExploreMapper, Explore> implements ExploreService {
    @Override
    public void save(ExploreDTO exploreDTO) {
        save(BeanConverter.toExplore(exploreDTO));
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public void update(Long id, ExploreDTO exploreDTO) {
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
