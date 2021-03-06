package com.yeternal.elf.util;

import cn.hutool.core.bean.BeanUtil;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.payload.ExploreRequest;
import com.yeternal.elf.model.payload.ShikigamiRequest;
import com.yeternal.elf.model.payload.SysUserRequest;
import com.yeternal.elf.model.entity.Explore;
import com.yeternal.elf.model.entity.Shikigami;
import com.yeternal.elf.model.entity.SysUser;
import com.yeternal.elf.model.vo.ExploreVO;
import com.yeternal.elf.model.vo.MappingVO;
import com.yeternal.elf.model.vo.ShikigamiVO;
import com.yeternal.elf.model.vo.SysUserVO;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.util
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/7 11:22
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
public class BeanConverter {

    //user ##################################################

    public static SysUserVO toUserVO(SysUser user) {
        SysUserVO vo = BeanUtil.toBean(user, SysUserVO.class);
        vo.setLastUpdateTime(user.getUpdateTime());
        return vo;
    }

    public static SysUser toUser(SysUserRequest userDTO) {
        return BeanUtil.toBean(userDTO, SysUser.class);
    }

    //Shikigami ##############################################

    public static ShikigamiVO toShikigamiVO(Shikigami shikigami) {
        return BeanUtil.toBean(shikigami, ShikigamiVO.class);
    }

    public static Shikigami toShikigami(ShikigamiRequest shikigamiDTO) {
        return BeanUtil.toBean(shikigamiDTO, Shikigami.class);
    }

    //Explore ##############################################

    public static ExploreVO toExploreVO(Explore explore, List<MappingVO> list) {
        ExploreVO exploreVO = BeanUtil.toBean(explore, ExploreVO.class);
        BeanUtil.copyProperties(explore, exploreVO);
        exploreVO.setMappingList(list);
        return exploreVO;
    }

    public static Explore toExplore(ExploreRequest exploreDTO) {
        return BeanUtil.toBean(exploreDTO, Explore.class);
    }
}
