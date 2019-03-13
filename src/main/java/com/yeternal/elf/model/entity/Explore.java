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
 * 探索实体类
 * </p>
 *
 * @package: com.yeternal.elf.model.entity
 * @description: 探索实体类
 * @author: eternallove
 * @date: Created in 2019/3/13 16:59
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("elf_explore")
public class Explore implements Serializable {

    private static final long serialVersionUID = 3110822385870392579L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 探索名称
     */
    private String name;

    /**
     * 关卡数
     */
    private Integer number;

    /**
     * 类型
     * {@link com.yeternal.elf.common.Constant#EXPLORE}:探索
     * {@link com.yeternal.elf.common.Constant#SEAL}:妖气封印
     * {@link com.yeternal.elf.common.Constant#SECRET}:秘闻
     */
    private String type;

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
