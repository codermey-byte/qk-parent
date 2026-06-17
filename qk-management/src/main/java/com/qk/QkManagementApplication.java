package com.qk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan // 开启对 Servlet 的支持
@SpringBootApplication
public class QkManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QkManagementApplication.class, args);
    }

}
