package com.qk.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 部门实体类
 * 对应数据库 dept 表
 */
@Data
public class Dept {
    /**
     * 部门ID，主键
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
