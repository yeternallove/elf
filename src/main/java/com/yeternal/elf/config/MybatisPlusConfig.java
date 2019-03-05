package com.yeternal.elf.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * <p>
 * mybatis-plus 配置
 * </p>
 *
 * @package: com.yeternal.elf.config
 * @description: mybatis-plus 配置
 * @author: eternallove
 * @date: Created in 2019/3/5 10:32
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: eternallove
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.yeternal.elf.mapper*"})
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
