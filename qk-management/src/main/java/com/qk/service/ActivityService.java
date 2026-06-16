package com.qk.service;

import com.qk.common.PageResult;
import com.qk.entity.Activity;

import java.util.List;

public interface ActivityService {
    /**
     * 新增活动
     *
     * @param activity
     */
    void addActivity(Activity activity);

    /**
     * 删除活动
     *
     * @param id
     */
    void deleteActivity(Integer id);

    /**
     * 更新活动
     *
     * @param activity
     */
    void updateActivity(Activity activity);

    /**
     * 根据 id 查询活动
     *
     * @param id
     * @return
     */
    Activity getActivityById(Integer id);

    /**
     * 活动列表（带分页）
     *
     * @param channel  活动渠道
     * @param type     活动类型
     * @param status   活动状态
     * @param page     页码
     * @param pageSize 每页条数
     * @return
     */
    PageResult<Activity> getActivities(Integer channel, Integer type, Integer status, Integer page, Integer pageSize);

    /**
     * 查询指定类型的活动
     *
     * @param type 活动类型
     * @return
     */
    List<Activity> getActivitiesByType(Integer type);


}
