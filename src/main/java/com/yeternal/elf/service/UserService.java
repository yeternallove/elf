package com.yeternal.elf.service;

import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.model.payload.LoginRequest;
import com.yeternal.elf.model.payload.PasswordRequest;
import com.yeternal.elf.model.dto.UserDTO;
import com.yeternal.elf.model.query.UserQuery;
import com.yeternal.elf.model.vo.UserVO;

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
     * @param userDTO {@link UserDTO}
     */
    void save(UserDTO userDTO);

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
     * @param userDTO {@link UserDTO}
     */
    void update(Long id, UserDTO userDTO);

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
     * @return {@link UserVO}
     */
    UserVO getUser(Long id);

    /**
     * 获取用户列表
     *
     * @param userQuery {@link UserQuery}
     * @return {@link UserVO}
     */
    PageResult<UserVO> listUser(UserQuery userQuery);

    /**
     * 获取单个用户通过用户名、邮箱、手机号（符合任一条件）并校验密码
     *
     * @param loginRequest {@link LoginRequest}
     * @return 登录成功返回 {@link UserVO}
     */
    UserVO login(LoginRequest loginRequest);
}
