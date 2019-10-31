package com.hwy.study01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 启动类
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        15:23 2019-10-29
 * @Version     v1
 **/
@SpringBootApplication
public class Study01Application {

    public static void main(String[] args) {
        SpringApplication.run(Study01Application.class, args);
    }

}
