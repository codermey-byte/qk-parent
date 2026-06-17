package com.qk.dto;

import lombok.Data;

/**
 * /users?name=张&status=1&phone=13309091111&deptId=5&page=1&pageSize=5
 * 封装查询参数
 */
@Data
public class UserDto {

    /**
     * 姓名
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 手机
     */
    private String phone;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

}