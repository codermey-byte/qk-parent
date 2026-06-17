package com.qk.dto;

import lombok.Data;

/**
 * 登录参数
 */
@Data
public class LoginDto {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
