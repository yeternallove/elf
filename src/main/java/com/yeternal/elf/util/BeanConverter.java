package com.yeternal.elf.util;

import cn.hutool.core.bean.BeanUtil;
import com.yeternal.elf.model.dto.ExploreDTO;
import com.yeternal.elf.model.dto.ShikigamiDTO;
import com.yeternal.elf.model.dto.UserDTO;
import com.yeternal.elf.model.entity.Explore;
import com.yeternal.elf.model.entity.Shikigami;
import com.yeternal.elf.model.entity.User;
import com.yeternal.elf.model.vo.ExploreVO;
import com.yeternal.elf.model.vo.ShikigamiVO;
import com.yeternal.elf.model.vo.UserVO;

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

    public static UserVO toUserVO(User user) {
        return BeanUtil.toBean(user, UserVO.class);
    }

    public static User toUser(UserDTO userDTO) {
        return BeanUtil.toBean(userDTO, User.class);
    }

    //Shikigami ##############################################

    public static ShikigamiVO toShikigamiVO(Shikigami shikigami) {
        return BeanUtil.toBean(shikigami, ShikigamiVO.class);
    }

    public static Shikigami toShikigami(ShikigamiDTO shikigamiDTO) {
        return BeanUtil.toBean(shikigamiDTO, Shikigami.class);
    }

    //Explore ##############################################

    public static ExploreVO toExploreVO(Explore explore) {
        return BeanUtil.toBean(explore, ExploreVO.class);
    }

    public static Explore toExplore(ExploreDTO exploreDTO) {
        return BeanUtil.toBean(exploreDTO, Explore.class);
    }
}
