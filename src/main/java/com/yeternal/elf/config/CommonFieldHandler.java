package com.yeternal.elf.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 通用字段填充
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 14:00
 */
@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        this.setInsertFieldValByName("createTime", now, metaObject);
        this.setInsertFieldValByName("updateTime", now, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("updateTime", new Date(), metaObject);
    }
}
