/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 5/6/23 21:10
 * description: 做什么的？
 */
package com.maike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({ "com.maike.webapp.function.mapper" })
public class GeekPlusXYZApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeekPlusXYZApplication.class,args);
    }
}
