package com.yeternal.elf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.vo.MappingVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.mapper
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 18:55
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Component
public interface MappingMapper extends BaseMapper<Mapping> {

    /**
     * 通过探索id查询列表
     *
     * @param id 探索id
     * @return {@link MappingVO}
     */
    @Select("SELECT m.*,s.name FROM ( select * from elf_mapping WHERE explore_id = #{id} ) m JOIN elf_shikigami s ON (s.id = m.shikigami_id)")
    List<MappingVO> listByExploreId(@Param("id") Long id);
}
