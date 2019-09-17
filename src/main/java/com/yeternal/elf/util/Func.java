package com.yeternal.elf.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.yeternal.elf.common.api.PageQuery;
import com.yeternal.elf.common.constants.CommonConst;
import com.yeternal.elf.common.enums.SortType;
import lombok.experimental.UtilityClass;
import org.springframework.context.ApplicationEvent;

import java.io.File;

/**
 * <p>
 * 快捷工具类
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:55
 */
@UtilityClass
public class Func {

    /**
     * 校验分页参数，为NULL，设置分页参数默认值
     *
     * @param query 查询参数
     * @param clazz 类
     * @param <T>   查询参数泛型 {@link PageQuery}
     * @return T
     */
    public <T extends PageQuery> T checkPageQuery(T query, Class<T> clazz) {
        if (ObjectUtil.isNull(query)) {
            query = ReflectUtil.newInstance(clazz);
        }
        // 校验分页参数
        if (ObjectUtil.isNull(query.getCurrentPage())) {
            query.setCurrentPage(CommonConst.DEFAULT_CURRENT_PAGE);
        }
        if (ObjectUtil.isNull(query.getPageSize())) {
            query.setPageSize(CommonConst.DEFAULT_PAGE_SIZE);
        }
        if (StrUtil.isNotBlank(query.getSortBy()) && StrUtil.isBlank(query.getSortType())) {
            query.setSortType(SortType.ASC.getType());
        }
        return query;
    }

    /**
     * 参数为NULL 则返回null
     * 校验分页参数，为NULL，设置分页参数默认值
     *
     * @param query 查询参数
     * @param <T>   查询参数泛型 {@link PageQuery}
     * @return T
     */
    public <T extends PageQuery> T checkPageQuery(T query) {
        if (ObjectUtil.isNull(query)) {
            return null;
        }
        return checkPageQuery(query, null);
    }

    /**
     * 填充排序参数
     *
     * @param query    查询参数
     * @param column   排序字段
     * @param sortType 排序类型
     * @param <T>      查询参数泛型  {@link PageQuery}
     */
    public <T extends PageQuery> void fillSort(T query, String column, SortType sortType) {
        query.setSortBy(column);
        query.setSortType(sortType.getType());
    }


    /**
     * 发布Spring Event
     *
     * @param event 事件
     */
    public void publishEvent(ApplicationEvent event) {
        SpringUtil.publishEvent(event);
    }

    /**
     * 包装文件路径，末尾添加文件分隔符
     *
     * @param filePath 文件路径
     * @return 带文件分隔符的文件路径
     */
    public String wrapFilePath(String filePath) {
        return StrUtil.appendIfMissing(filePath, File.separator);
    }

}
