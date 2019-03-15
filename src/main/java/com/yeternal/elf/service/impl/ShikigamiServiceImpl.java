package com.yeternal.elf.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.common.Status;
import com.yeternal.elf.exception.ElfException;
import com.yeternal.elf.mapper.ShikigamiMapper;
import com.yeternal.elf.model.dto.ShikigamiDTO;
import com.yeternal.elf.model.entity.Shikigami;
import com.yeternal.elf.model.query.ShikigamiQuery;
import com.yeternal.elf.model.vo.ShikigamiVO;
import com.yeternal.elf.service.ShikigamiService;
import com.yeternal.elf.util.BeanConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.service.impl
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 16:36
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Service
public class ShikigamiServiceImpl extends ServiceImpl<ShikigamiMapper, Shikigami> implements ShikigamiService {
    @Override
    public void save(ShikigamiDTO shikigamiDTO) {
        QueryWrapper<Shikigami> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Shikigami::getName, shikigamiDTO.getName());
        Shikigami one = getOne(wrapper);
        if (ObjectUtil.isNotNull(one)) {
            throw new ElfException(Status.EXISTING_REPEAT);
        }
        save(BeanConverter.toShikigami(shikigamiDTO));
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public void update(Long id, ShikigamiDTO shikigamiDTO) {
        updateById(BeanConverter.toShikigami(shikigamiDTO));
    }

    @Override
    public ShikigamiVO getShikigami(Long id) {
        return BeanConverter.toShikigamiVO(getById(id));
    }

    @Override
    public PageResult<ShikigamiVO> listShikigami(ShikigamiQuery shikigamiQuery) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        countDownLatch.countDown();
        QueryWrapper<Shikigami> wrapper = new QueryWrapper<>();
        String name = shikigamiQuery.getName();
        boolean like = StrUtil.isNotBlank(name);
        Integer rare = shikigamiQuery.getRare();
        boolean eq = Objects.nonNull(rare);
        wrapper.lambda().and(like, f -> f.like(Shikigami::getName, name).or().like(Shikigami::getAlias, name)).eq(eq, Shikigami::getRare, rare);
        List<ShikigamiVO> list = page(shikigamiQuery.page(), wrapper).getRecords().stream().map(BeanConverter::toShikigamiVO).collect(Collectors.toList());
        return PageResult.of(count(), list);
    }
}
