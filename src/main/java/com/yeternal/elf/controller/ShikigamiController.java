package com.yeternal.elf.controller;

import com.yeternal.elf.common.R;
import com.yeternal.elf.model.dto.ShikigamiDTO;
import com.yeternal.elf.model.query.ShikigamiQuery;
import com.yeternal.elf.service.ShikigamiService;
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
 * @date: Created in 2019/3/13 16:33
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/ss")
public class ShikigamiController {

    private ShikigamiService shikigamiService;

    /**
     * 新增式神
     *
     * @param shikigamiDTO {@link ShikigamiDTO}
     * @return {@link R}
     */
    @PostMapping
    public R save(@Validated @RequestBody ShikigamiDTO shikigamiDTO) {
        shikigamiService.save(shikigamiDTO);
        return R.ofSuccess();
    }

    /**
     * 删除式神
     *
     * @param id 式神id
     * @return {@link R}
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        shikigamiService.delete(id);
        return R.ofSuccess();
    }

    /**
     * 更新式神信息
     *
     * @param id           式神id
     * @param shikigamiDTO {@link ShikigamiDTO}
     * @return {@link R}
     */
    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Validated @RequestBody ShikigamiDTO shikigamiDTO) {
        shikigamiService.update(id, shikigamiDTO);
        return R.ofSuccess();
    }

    /**
     * 获取单个式神详情
     *
     * @param id 式神id
     * @return {@link R}
     */
    @GetMapping("/{id}")
    public R getShikigami(@PathVariable Long id) {
        return R.ofSuccess(shikigamiService.getShikigami(id));
    }

    /**
     * 获取式神列表
     *
     * @param shikigamiQuery {@link ShikigamiQuery}
     * @return {@link R}
     */
    @GetMapping("/list")
    public R listShikigami(ShikigamiQuery shikigamiQuery) {
        return R.ofSuccess(shikigamiService.listShikigami(shikigamiQuery));
    }

}
