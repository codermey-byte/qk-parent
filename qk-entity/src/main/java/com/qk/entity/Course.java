package com.qk.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 课程实体类
 */
@Data
public class Course {
    /**
     * 课程ID，主键
     */
    private Integer id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程学科
     */
    private Integer subject;
    /**
     * 适用人群
     */
    private Integer target;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 课程介绍
     */
    private String description;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
