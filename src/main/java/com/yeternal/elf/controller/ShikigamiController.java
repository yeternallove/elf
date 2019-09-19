package com.yeternal.elf.controller;

import com.yeternal.elf.common.api.R;
import com.yeternal.elf.model.payload.ShikigamiRequest;
import com.yeternal.elf.model.query.ShikigamiQuery;
import com.yeternal.elf.service.ShikigamiService;
import com.yeternal.elf.util.Func;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:37
 */
@CrossOrigin
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/ss")
public class ShikigamiController {

    private ShikigamiService shikigamiService;

    /**
     * 新增式神
     *
     * @param shikigamiDTO {@link ShikigamiRequest}
     * @return {@link R}
     */
    @PostMapping
    public R save(@Validated @RequestBody ShikigamiRequest shikigamiDTO) {
        shikigamiService.save(shikigamiDTO);
        return R.success();
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
        return R.success();
    }

    /**
     * 更新式神信息
     *
     * @param id           式神id
     * @param shikigamiDTO {@link ShikigamiRequest}
     * @return {@link R}
     */
    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Validated @RequestBody ShikigamiRequest shikigamiDTO) {
        shikigamiService.update(id, shikigamiDTO);
        return R.success();
    }

    /**
     * 获取单个式神详情
     *
     * @param id 式神id
     * @return {@link R}
     */
    @GetMapping("/{id}")
    public R getShikigami(@PathVariable Long id) {
        return R.success(shikigamiService.getShikigami(id));
    }

    /**
     * 获取式神列表
     *
     * @param shikigamiQuery {@link ShikigamiQuery}
     * @return {@link R}
     */
    @GetMapping("/list")
    public R listShikigami(ShikigamiQuery shikigamiQuery) {
        Func.checkPageQuery(shikigamiQuery);
        return R.success(shikigamiService.listShikigami(shikigamiQuery));
    }

}
