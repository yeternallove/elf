package com.yeternal.elf.util;

import cn.hutool.core.bean.BeanUtil;
import com.yeternal.elf.model.dto.UserDTO;
import com.yeternal.elf.model.entity.User;
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
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(user, userVO);
        return userVO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        BeanUtil.copyProperties(userDTO, user);
        return user;
    }
}
