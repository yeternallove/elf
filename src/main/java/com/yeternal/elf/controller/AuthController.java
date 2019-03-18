package com.yeternal.elf.controller;

import com.yeternal.elf.common.R;
import com.yeternal.elf.common.Status;
import com.yeternal.elf.model.payload.LoginRequest;
import com.yeternal.elf.model.vo.SysUserVO;
import com.yeternal.elf.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.controller
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/7 9:28
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public R login(@Validated @RequestBody LoginRequest loginRequest) {
        SysUserVO userVO = userService.login(loginRequest);
        if (Objects.isNull(userVO)) {
            return R.ofStatus(Status.LOGIN_INFO_ERROR);
        }
        return R.ofSuccess(userVO);
    }

    @PostMapping("/logout")
    public R logout() {
        return R.ofSuccess();
    }
}
