package com.yeternal.elf.controller;

import com.yeternal.elf.common.api.R;
import com.yeternal.elf.model.entity.Mapping;
import com.yeternal.elf.model.payload.ExploreRequest;
import com.yeternal.elf.model.query.ExploreQuery;
import com.yeternal.elf.service.ExploreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@CrossOrigin
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/explore")
public class ExploreController {

    private final ExploreService exploreService;

    /**
     * 新增探索
     *
     * @param exploreDTO {@link ExploreRequest}
     * @return {@link R}
     */
    @PostMapping
    public R save(@Validated @RequestBody ExploreRequest exploreDTO) {
        exploreService.save(exploreDTO);
        return R.success();
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
        return R.success();
    }

    /**
     * 更新探索信息
     *
     * @param id         探索id
     * @param exploreDTO {@link ExploreRequest}
     * @return {@link R}
     */
    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Validated @RequestBody ExploreRequest exploreDTO) {
        exploreService.update(id, exploreDTO);
        return R.success();
    }

    @PutMapping("/mapping/{id}")
    public R updateMapping(@PathVariable Long id, @Validated @RequestBody List<Mapping> mappings) {
        exploreService.updateMapping(id, mappings);
        return R.success();
    }

    /**
     * 获取单个探索详情
     *
     * @param id 探索id
     * @return {@link R}
     */
    @GetMapping("/{id}")
    public R getExplore(@PathVariable Long id) {
        return R.success(exploreService.getExplore(id));
    }

    /**
     * 获取探索列表
     *
     * @param exploreQuery {@link ExploreQuery}
     * @return {@link R}
     */
    @GetMapping("/list")
    public R listExplore(ExploreQuery exploreQuery) {
        return R.success(exploreService.listExplore(exploreQuery));
    }
}
