package com.yeternal.elf.service;

import com.yeternal.elf.common.PageResult;
import com.yeternal.elf.model.payload.ShikigamiRequest;
import com.yeternal.elf.model.query.ShikigamiQuery;
import com.yeternal.elf.model.vo.ShikigamiVO;

/**
 * <p>
 * 式神管理
 * </p>
 *
 * @package: com.yeternal.elf.service
 * @description: 式神管理
 * @author: eternallove
 * @date: Created in 2019/3/13 16:36
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
public interface ShikigamiService {

    /**
     * 新增式神
     *
     * @param shikigamiDTO {@link ShikigamiRequest}
     */
    void save(ShikigamiRequest shikigamiDTO);

    /**
     * 删除式神
     *
     * @param id 式神id
     */
    void delete(Long id);

    /**
     * 更新式神（不支持密码修改）
     *
     * @param id      式神id
     * @param shikigamiDTO {@link ShikigamiRequest}
     */
    void update(Long id, ShikigamiRequest shikigamiDTO);
    

    /**
     * 获取单个式神通过id
     *
     * @param id 式神id
     * @return {@link ShikigamiVO}
     */
    ShikigamiVO getShikigami(Long id);

    /**
     * 获取式神列表
     *
     * @param shikigamiQuery {@link ShikigamiQuery}
     * @return {@link ShikigamiVO}
     */
    PageResult<ShikigamiVO> listShikigami(ShikigamiQuery shikigamiQuery);
    
}
