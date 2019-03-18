package com.yeternal.elf.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

/**
 * <p>
 * 用户实体类
 * </p>
 *
 * @package: com.yeternal.elf.model
 * @description: 用户实体类
 * @author: eternallove
 * @date: Created in 2019/3/2 14:07
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("elf_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = -8250490250545406986L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 加密使用的盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 状态
     * {@link com.yeternal.elf.common.Constant#USER_DELETE}:逻辑删除
     * {@link com.yeternal.elf.common.Constant#USER_DISABLE}:禁用
     * {@link com.yeternal.elf.common.Constant#USER_ENABLE}:启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = INSERT)
    private Date createTime;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    @TableField(fill = INSERT_UPDATE)
    private Date lastUpdateTime;
}