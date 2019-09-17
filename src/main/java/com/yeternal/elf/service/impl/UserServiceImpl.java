package com.yeternal.elf.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.elf.common.api.PageResult;
import com.yeternal.elf.mapper.UserMapper;
import com.yeternal.elf.model.payload.SysUserRequest;
import com.yeternal.elf.model.entity.SysUser;
import com.yeternal.elf.model.payload.LoginRequest;
import com.yeternal.elf.model.payload.PasswordRequest;
import com.yeternal.elf.model.query.SysUserQuery;
import com.yeternal.elf.model.vo.SysUserVO;
import com.yeternal.elf.service.UserService;
import com.yeternal.elf.util.BeanConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @package: com.yeternal.elf.service.impl
 * @description: 用户管理
 * @author: eternallove
 * @date: Created in 2019/3/2 18:12
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {

    @Override
    public void save(SysUserRequest userDTO) {
        final SysUser user = BeanConverter.toUser(userDTO);
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
    public void update(Long id, SysUserRequest userDTO) {
        updateById(BeanConverter.toUser(userDTO));
    }

    @Override
    public void updatePassword(Long id, PasswordRequest passwordDTO) {
        SysUser user = getById(id);
        final SysUser user2 = new SysUser();
        user2.setId(id).setPassword(getEncryptedPassword(passwordDTO.getNewPwd(), user.getSalt()));
        updateById(user);
    }

    @Override
    public SysUserVO getUser(Long id) {
        return BeanConverter.toUserVO(getById(id));
    }

    @Override
    public PageResult<SysUserVO> listUser(SysUserQuery userQuery) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        List<SysUserVO> list = page(userQuery.page(), wrapper).getRecords().stream().map(BeanConverter::toUserVO).collect(Collectors.toList());
        return PageResult.of(count(), list);
    }

    @Override
    public SysUserVO login(LoginRequest loginRequest) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        String name = loginRequest.getUsernameOrEmailOrPhone();
        wrapper.lambda().eq(SysUser::getName, name).or().eq(SysUser::getEmail, name).or().eq(SysUser::getPhoneNumber, name);
        SysUser user = getOne(wrapper);
        if (Objects.nonNull(user) && checkPassword(loginRequest.getPassword(), user.getSalt(), user.getPassword())) {
            return BeanConverter.toUserVO(user);
        }
        return null;
    }

    private String getEncryptedPassword(String pwd, String salt) {
        return SecureUtil.md5(pwd + salt);
    }

    private boolean checkPassword(String pwd, String salt, String cipher) {
        return StrUtil.equals(getEncryptedPassword(pwd, salt), cipher);
    }
}
