package com.yeternal.elf.service;

import com.yeternal.elf.common.api.PageResult;
import com.yeternal.elf.model.entity.Explore;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.payload.ExploreRequest;
import com.yeternal.elf.model.query.ExploreQuery;
import com.yeternal.elf.model.vo.ExploreVO;

import java.util.List;

/**
 * <p>
 * 探索管理
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 14:54
 */
public interface ExploreService {

    /**
     * 新增探索
     *
     * @param exploreDTO {@link ExploreRequest}
     */
    void save(ExploreRequest exploreDTO);

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
     * @param exploreDTO {@link ExploreRequest}
     */
    void update(Long id, ExploreRequest exploreDTO);

    /**
     * 更新探索映射
     *
     * @param id       探索id
     * @param mappings {@link Mapping}
     */
    void updateMapping(Long id, List<Mapping> mappings);

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
    PageResult<Explore> listExplore(ExploreQuery exploreQuery);

}
