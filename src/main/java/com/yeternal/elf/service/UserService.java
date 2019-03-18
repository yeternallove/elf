package com.yeternal.elf.service;

import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.model.payload.LoginRequest;
import com.yeternal.elf.model.payload.PasswordRequest;
import com.yeternal.elf.model.payload.SysUserRequest;
import com.yeternal.elf.model.query.SysUserQuery;
import com.yeternal.elf.model.vo.SysUserVO;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @package: com.yeternal.elf.service
 * @description: 用户管理
 * @author: eternallove
 * @date: Created in 2019/3/2 18:10
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param userDTO {@link SysUserRequest}
     */
    void save(SysUserRequest userDTO);

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    void delete(Long id);

    /**
     * 更新用户（不支持密码修改）
     *
     * @param id      用户id
     * @param userDTO {@link SysUserRequest}
     */
    void update(Long id, SysUserRequest userDTO);

    /**
     * 更新用户密码
     *
     * @param id          用户id
     * @param passwordDTO {@link PasswordRequest}
     */
    void updatePassword(Long id, PasswordRequest passwordDTO);

    /**
     * 获取单个用户通过id
     *
     * @param id 用户id
     * @return {@link SysUserVO}
     */
    SysUserVO getUser(Long id);

    /**
     * 获取用户列表
     *
     * @param userQuery {@link SysUserQuery}
     * @return {@link SysUserVO}
     */
    PageResult<SysUserVO> listUser(SysUserQuery userQuery);

    /**
     * 获取单个用户通过用户名、邮箱、手机号（符合任一条件）并校验密码
     *
     * @param loginRequest {@link LoginRequest}
     * @return 登录成功返回 {@link SysUserVO}
     */
    SysUserVO login(LoginRequest loginRequest);
}
