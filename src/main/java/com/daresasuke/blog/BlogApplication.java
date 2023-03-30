package com.daresasuke.blog;

/**
 * @Author:DareSasuke
 * @DATA:2021/10/30:22:38
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("/com.daresasuke.blog.Dao/")
@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
