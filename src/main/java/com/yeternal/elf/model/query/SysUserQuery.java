package com.yeternal.elf.model.query;

import com.yeternal.elf.common.api.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户查询
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserQuery extends PageQuery {
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
     * 上次登录时间
     */
    private Long lastLoginTime;

}
