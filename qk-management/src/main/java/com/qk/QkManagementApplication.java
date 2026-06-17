package com.qk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ServletComponentScan // 开启对 Servlet 的支持
@SpringBootApplication
public class QkManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QkManagementApplication.class, args);
    }

}
