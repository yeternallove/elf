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
 * @author eternallove
 * @date Created in 2019/9/17 14:23
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
