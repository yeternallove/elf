package com.yeternal.elf.common;

import lombok.Getter;

/**
 * <p>
 * 状态码封装
 * </p>
 *
 * @package: com.yeternal.elf.common
 * @description: 状态码封装
 * @author: yangkai.shen
 * @date: Created in 2018/11/16 13:24
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@Getter
public enum Status {
    /**
     * 正常
     */
    OK(200, "正常"),
    /**
     * 请求错误
     */
    BAD_REQUEST(400, "请求错误"),
    /**
     * Unauthorized
     */
    NO_AUTHORIZATION(401, "未经授权的"),
    /**
     * 用户名或密码错误
     */
    LOGIN_INFO_ERROR(402, "用户名或密码错误！"),
    /**
     * 服务器解析不到用户请求的服务名称
     */
    REQUEST_NOT_FOUND(404, "服务不存在"),
    /**
     * 请求方式不支持！
     */
    HTTP_BAD_METHOD(405, "请求方式不支持！"),
    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500, "服务器内部错误"),
    /**
     * 未定义异常
     */
    UNDEFINED(501, "未定义"),
    /**
     * 该服务已下线
     */
    SERVICES_DISABLED(1, "服务未启用"),
    /**
     * 请求参数不能为空
     */
    PARAM_NOT_NULL(101, "请求参数不能为空"),
    /**
     * 参数不匹配
     */
    PARAM_NOT_MATCH(102, "参数不匹配"),
    /**
     * 权限认证参数
     */
    NO_AUT_PARAM(103, "权限参数不存在"),
    /**
     * 日期格式错误
     */
    DATE_FORMAT_EXCEPTION(104, "日期格式错误"),
    /**
     * 无效数据库配置
     */
    INVALID_DB_CONFIG(603, "无效数据库配置"),
    /**
     * 数据库配置不存在
     */
    DB_CONFIG_NOT_EXIST(604, "数据库配置不存在"),
    /**
     * 数据库配置已存在
     */
    DB_CONFIG_EXISTED(605, "数据库配置已存在"),
    /**
     * 数据库连接异常
     */
    CONNECTION_FAILED(605, "数据库连接异常");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 内容
     */
    private final String reasonPhrase;

    Status(Integer code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }
}
