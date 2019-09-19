package com.yeternal.elf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/19 17:10
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
