package com.qk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 活动管理实体类
 * 对应数据库 activity 表
 */
@Data
public class Activity {
    /**
     * 活动id，主键
     */
    private Integer id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动渠道，1：线上活动，2：推广介绍
     */
    private Integer channel;

    /**
     * 活动类型，1：课程折扣，2：代金券
     */
    private Integer type;

    /**
     * 活动简介
     */
    private String description;

    /**
     * 活动状态 1：未开始，2：进行中，3：已结束
     */
    private Integer status;

    /**
     * 活动开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 活动结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 课程折扣，整数个位数字，或者小数，支持小数点后1位，如：8.8，8.0，7.5，6.0等
     */
    private BigDecimal discount;

    /**
     * 代金券金额（元）
     */
    private BigDecimal voucher;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
