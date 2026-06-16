package com.qk.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Activity;
import com.qk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 新增活动
     *
     * @param activity
     * @return
     */
    @PostMapping("/activities")
    public Result addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);
        return Result.success();
    }

    /**
     * 删除活动
     *
     * @param id
     * @return
     */
    @DeleteMapping("/activities/{id}")
    public Result deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
        return Result.success();
    }

    /**
     * 更新活动
     *
     * @param activity
     * @return
     */
    @PutMapping("/activities")
    public Result updateActivity(@RequestBody Activity activity) {
        activityService.updateActivity(activity);
        return Result.success();
    }

    /**
     * 根据 id 查询活动
     *
     * @param id
     * @return
     */
    @GetMapping("/activities/{id}")
    public Result getActivityById(@PathVariable Integer id) {
        Activity activity = activityService.getActivityById(id);
        return Result.success(activity);
    }

    /**
     * 活动列表（带分页）
     *
     * @param channel  活动渠道
     * @param type     活动类型
     * @param status   活动状态
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/activities")
    public Result getActivities(
            Integer channel,
            Integer type,
            Integer status,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageResult<Activity> activities = activityService.getActivities(channel, type, status, page, pageSize);
        return Result.success(activities);
    }

    /**
     * 查询指定类型的活动
     *
     * @param type
     * @return
     */
    @GetMapping("/activities/type/{type}")
    public Result getActivitiesByType(@PathVariable Integer type) {
        List<Activity> activities = activityService.getActivitiesByType(type);
        return Result.success(activities);
    }
}
