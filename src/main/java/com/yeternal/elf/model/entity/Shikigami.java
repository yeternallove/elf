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
 * 式神实体类
 * </p>
 *
 * @package: com.yeternal.elf.model.entity
 * @description: 式神实体类
 * @author: eternallove
 * @date: Created in 2019/3/13 17:00
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("elf_shikigami")
public class Shikigami implements Serializable {

    private static final long serialVersionUID = -5885920202837074647L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 式神名
     */
    private String name;

    /**
     * 稀有度
     * {@link com.yeternal.elf.common.Constant#RARE_DEFAULT}:默认（未知）
     * {@link com.yeternal.elf.common.Constant#RARE_GUA}:呱
     * {@link com.yeternal.elf.common.Constant#RARE_N}:N
     * {@link com.yeternal.elf.common.Constant#RARE_R}:R
     * {@link com.yeternal.elf.common.Constant#RARE_SR}:SR
     * {@link com.yeternal.elf.common.Constant#RARE_SSR}:SSR
     * {@link com.yeternal.elf.common.Constant#RARE_SP}:SP
     */
    private Integer rare;

    /**
     * 别称
     */
    private String alias;

    /**
     * 创建时间
     */
    @TableField(fill = INSERT)
    private Date createTime;

    /**
     * 上次更新时间
     */
    @TableField(fill = INSERT_UPDATE)
    private Date lastUpdateTime;
}
