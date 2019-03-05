package com.yeternal.elf.controller;

import com.yeternal.elf.common.ApiResponse;
import com.yeternal.elf.model.dto.PasswordDTO;
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
     * @return {@link ApiResponse}
     */
    @PostMapping
    public ApiResponse save(@Validated @RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ApiResponse.ofSuccess();
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return {@link ApiResponse}
     */
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Long id) {
        userService.delete(id);
        return ApiResponse.ofSuccess();
    }

    /**
     * 更新用户信息
     *
     * @param id      用户id
     * @param userDTO {@link UserDTO}
     * @return {@link ApiResponse}
     */
    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Long id, @Validated @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return ApiResponse.ofSuccess();
    }

    /**
     * 修改用户密码
     *
     * @param passwordDTO {@link PasswordDTO}
     * @return {@link ApiResponse}
     */
    @PutMapping(value = "/{id}", params = "change")
    public ApiResponse changePassword(@PathVariable Long id, @Validated @RequestBody PasswordDTO passwordDTO) {
        userService.updatePassword(id, passwordDTO);
        return ApiResponse.ofSuccess();
    }

    /**
     * 重置用户密码
     *
     * @param passwordDTO {@link PasswordDTO}
     * @return {@link ApiResponse}
     */
    @PutMapping(value = "/{id}", params = "reset")
    public ApiResponse resetPassword(@PathVariable Long id, @Validated @RequestBody PasswordDTO passwordDTO) {
        userService.updatePassword(id, passwordDTO);
        return ApiResponse.ofSuccess();
    }

    /**
     * 获取单个用户详情
     *
     * @param id 用户id
     * @return {@link ApiResponse}
     */
    @GetMapping("/{id}")
    public ApiResponse getUser(@PathVariable Long id) {
        return ApiResponse.ofSuccess(userService.getUser(id));
    }

    /**
     * 获取用户列表
     *
     * @param userQuery {@link UserQuery}
     * @return {@link ApiResponse}
     */
    @GetMapping("/list")
    public ApiResponse listUser(UserQuery userQuery) {
        return ApiResponse.ofSuccess(userService.listUser(userQuery));
    }

}
