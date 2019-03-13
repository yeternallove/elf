package com.yeternal.elf.service;

import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.model.dto.ExploreDTO;
import com.yeternal.elf.model.query.ExploreQuery;
import com.yeternal.elf.model.vo.ExploreVO;

/**
 * <p>
 * 探索管理
 * </p>
 *
 * @package: com.yeternal.elf.service
 * @description: 探索管理
 * @author: eternallove
 * @date: Created in 2019/3/13 18:46
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
public interface ExploreService {

    /**
     * 新增探索
     *
     * @param exploreDTO {@link ExploreDTO}
     */
    void save(ExploreDTO exploreDTO);

    /**
     * 删除探索
     *
     * @param id 探索id
     */
    void delete(Long id);

    /**
     * 更新探索
     *
     * @param id         探索id
     * @param exploreDTO {@link ExploreDTO}
     */
    void update(Long id, ExploreDTO exploreDTO);


    /**
     * 获取单个探索通过id
     *
     * @param id 探索id
     * @return {@link ExploreVO}
     */
    ExploreVO getExplore(Long id);

    /**
     * 获取探索列表
     *
     * @param exploreQuery {@link ExploreQuery}
     * @return {@link ExploreVO}
     */
    PageResult<ExploreVO> listExplore(ExploreQuery exploreQuery);

}
