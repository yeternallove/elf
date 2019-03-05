package com.yeternal.elf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeternal.elf.model.entity.User;
import org.springframework.stereotype.Component;

/**
 * <p>
 * User Mapper
 * </p>
 *
 * @package: com.yeternal.elf.mapper
 * @description: User Mapper
 * @author: eternallove
 * @date: Created in 2019/3/2 14:10
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
