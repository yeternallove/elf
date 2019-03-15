package com.yeternal.elf.model.query;

import com.yeternal.elf.common.PageCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.model.QO
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/4 14:35
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends PageCondition {
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
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 上次登录时间
     */
    private Long lastLoginTime;

    /**
     * 上次更新时间
     */
    private Long lastUpdateTime;
}
