package com.yeternal.elf.controller;

import com.yeternal.elf.common.R;
import com.yeternal.elf.model.payload.PasswordRequest;
import com.yeternal.elf.model.dto.UserDTO;
import com.yeternal.elf.model.query.UserQuery;
import com.yeternal.elf.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @package: com.yeternal.elf.controller
 * @description: 用户管理
 * @author: eternallove
 * @date: Created in 2019/3/4 10:25
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 新增用户
     *
     * @param userDTO {@link UserDTO}
     * @return {@link R}
     */
    @PostMapping
    public R save(@Validated @RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return R.ofSuccess();
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return {@link R}
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        userService.delete(id);
        return R.ofSuccess();
    }

    /**
     * 更新用户信息
     *
     * @param id      用户id
     * @param userDTO {@link UserDTO}
     * @return {@link R}
     */
    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Validated @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return R.ofSuccess();
    }

    /**
     * 修改用户密码
     *
     * @param passwordDTO {@link PasswordRequest}
     * @return {@link R}
     */
    @PutMapping(value = "/{id}", params = "change")
    public R changePassword(@PathVariable Long id, @Validated @RequestBody PasswordRequest passwordDTO) {
        userService.updatePassword(id, passwordDTO);
        return R.ofSuccess();
    }

    /**
     * 重置用户密码
     *
     * @param passwordDTO {@link PasswordRequest}
     * @return {@link R}
     */
    @PutMapping(value = "/{id}", params = "reset")
    public R resetPassword(@PathVariable Long id, @Validated @RequestBody PasswordRequest passwordDTO) {
        userService.updatePassword(id, passwordDTO);
        return R.ofSuccess();
    }

    /**
     * 获取单个用户详情
     *
     * @param id 用户id
     * @return {@link R}
     */
    @GetMapping("/{id}")
    public R getUser(@PathVariable Long id) {
        return R.ofSuccess(userService.getUser(id));
    }

    /**
     * 获取用户列表
     *
     * @param userQuery {@link UserQuery}
     * @return {@link R}
     */
    @GetMapping("/list")
    public R listUser(UserQuery userQuery) {
        return R.ofSuccess(userService.listUser(userQuery));
    }

}
