package com.yeternal.elf.common;

/**
 * <p>
 * 常量池
 * </p>
 *
 * @package: com.yeternal.elf.common
 * @description: 常量池
 * @author: eternallove
 * @date: Created in 2019/3/1 17:20
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
public interface Constant {
    /**
     * 用户状态
     */
    int USER_DELETE = -1;
    int USER_DISABLE = 0;
    int USER_ENABLE = 1;
    /**
     * 稀有度
     */
    int RARE_DEFAULT = -1;
    int RARE_GUA = 0;
    int RARE_N = 1;
    int RARE_R = 2;
    int RARE_SR = 3;
    int RARE_SSR = 4;
    int RARE_SP = 5;
    /**
     * 探索类别
     */
    int EXPLORE = 1;
    int SEAL = 2;
    int SECRET = 3;

    /**
     * 默认当前页
     */
    int DEFAULT_CURRENT = 1;
    /**
     * 默认分页条数
     */
    int DEFAULT_SIZE = 10;
}
