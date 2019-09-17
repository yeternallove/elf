package com.yeternal.elf.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 映射关系
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("elf_mapping")
public class Mapping implements Serializable {
    private static final long serialVersionUID = -4786884531631574897L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 式神id
     */
    private Long shikigamiId;

    /**
     * 探索id
     */
    private Long exploreId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 备注
     */
    private String note;
}
