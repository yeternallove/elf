package com.yeternal.elf.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.vo
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/4 11:21
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
public class UserVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    private Date lastUpdateTime;
}
