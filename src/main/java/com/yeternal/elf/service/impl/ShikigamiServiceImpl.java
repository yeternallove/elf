package com.yeternal.elf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.mapper.ShikigamiMapper;
import com.yeternal.elf.model.dto.ShikigamiDTO;
import com.yeternal.elf.model.entity.Shikigami;
import com.yeternal.elf.model.query.ShikigamiQuery;
import com.yeternal.elf.model.vo.ShikigamiVO;
import com.yeternal.elf.service.ShikigamiService;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, ShikigamiDTO shikigamiDTO) {

    }

    @Override
    public ShikigamiVO getShikigami(Long id) {
        return null;
    }

    @Override
    public PageResult<ShikigamiVO> listShikigami(ShikigamiQuery shikigamiQuery) {
        return null;
    }
}
