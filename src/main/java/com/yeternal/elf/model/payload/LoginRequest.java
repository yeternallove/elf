package com.yeternal.elf.model.payload;

import com.yeternal.elf.common.Constraints;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 登录请求参数
 * </p>
 *
 * @package: com.yeternal.elf.model.payload
 * @description: 登录请求参数
 * @author: yangkai.shen
 * @date: Created in 2018-12-10 15:52
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@Data
public class LoginRequest {

    /**
     * 用户名或邮箱或手机号
     */
    @NotBlank(message = "用户名不能为空")
    private String usernameOrEmailOrPhone;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe = false;

}
