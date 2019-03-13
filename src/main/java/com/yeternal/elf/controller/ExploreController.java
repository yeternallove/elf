package com.yeternal.elf.controller;

import com.yeternal.elf.common.R;
import com.yeternal.elf.model.dto.ExploreDTO;
import com.yeternal.elf.model.query.ExploreQuery;
import com.yeternal.elf.service.ExploreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.elf.controller
 * @description:
 * @author: eternallove
 * @date: Created in 2019/3/13 16:35
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/explore")
public class ExploreController {

    private final ExploreService exploreService;

    /**
     * 新增探索
     *
     * @param exploreDTO {@link ExploreDTO}
     * @return {@link R}
     */
    @PostMapping
    public R save(@Validated @RequestBody ExploreDTO exploreDTO) {
        exploreService.save(exploreDTO);
        return R.ofSuccess();
    }

    /**
     * 删除探索
     *
     * @param id 探索id
     * @return {@link R}
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        exploreService.delete(id);
        return R.ofSuccess();
    }

    /**
     * 更新探索信息
     *
     * @param id         探索id
     * @param exploreDTO {@link ExploreDTO}
     * @return {@link R}
     */
    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Validated @RequestBody ExploreDTO exploreDTO) {
        exploreService.update(id, exploreDTO);
        return R.ofSuccess();
    }

    /**
     * 获取单个探索详情
     *
     * @param id 探索id
     * @return {@link R}
     */
    @GetMapping("/{id}")
    public R getExplore(@PathVariable Long id) {
        return R.ofSuccess(exploreService.getExplore(id));
    }

    /**
     * 获取探索列表
     *
     * @param exploreQuery {@link ExploreQuery}
     * @return {@link R}
     */
    @GetMapping("/list")
    public R listExplore(ExploreQuery exploreQuery) {
        return R.ofSuccess(exploreService.listExplore(exploreQuery));
    }
}
