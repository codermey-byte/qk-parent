package com.qk.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色实体类
 * 对应数据可 Role 表
 */
@Data
public class Role {
    /**
     * 角色id，主键
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色标识
     */
    private String label;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
