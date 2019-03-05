package com.yeternal.elf.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.mapper.UserMapper;
import com.yeternal.elf.model.dto.PasswordDTO;
import com.yeternal.elf.model.dto.UserDTO;
import com.yeternal.elf.model.entity.User;
import com.yeternal.elf.model.query.UserQuery;
import com.yeternal.elf.model.vo.UserVO;
import com.yeternal.elf.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
 * @date: Created in 2019/3/2 18:12
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void save(UserDTO userDTO) {
        final User user = new User();
        BeanUtil.copyProperties(userDTO, user);
        final String salt = IdUtil.fastSimpleUUID();
        final String password = getEncryptedPassword(userDTO.getPassword(), salt);
        user.setSalt(salt).setPassword(password);
        save(user);
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public void update(Long id, UserDTO userDTO) {
        final User user = new User();
        BeanUtil.copyProperties(userDTO, user);
        updateById(user);
    }

    @Override
    public void updatePassword(Long id, PasswordDTO passwordDTO) {
        User user = getById(id);
        final User user2 = new User();
        user2.setId(id).setPassword(getEncryptedPassword(passwordDTO.getNewPwd(), user.getSalt()));
        updateById(user);
    }

    @Override
    public UserVO getUser(Long id) {
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(getById(id), userVO);
        return userVO;
    }

    @Override
    public PageResult<UserVO> listUser(UserQuery userQuery) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(userQuery.getCurrentPage(), userQuery.getPageSize());
        List<UserVO> list = page(page, wrapper).getRecords().stream().map(user -> {
            UserVO userVO = new UserVO();
            BeanUtil.copyProperties(user, userVO);
            return userVO;
        }).collect(Collectors.toList());
        return PageResult.of(count(), list);
    }

    private String getEncryptedPassword(String pwd, String salt) {
        return SecureUtil.md5(pwd + salt);
    }

    private boolean checkPassword() {
        return false;
    }
}
