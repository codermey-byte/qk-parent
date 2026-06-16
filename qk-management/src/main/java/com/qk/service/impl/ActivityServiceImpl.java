package com.qk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.entity.Activity;
import com.qk.mapper.ActivityMapper;
import com.qk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public void addActivity(Activity activity) {
        activityMapper.addActivity(activity);
    }

    @Override
    public void deleteActivity(Integer id) {
        activityMapper.deleteActivity(id);
    }

    @Override
    public void updateActivity(Activity activity) {
        activityMapper.updateActivity(activity);
    }

    @Override
    public Activity getActivityById(Integer id) {
        return activityMapper.getActivityById(id);
    }

    @Override
    public PageResult<Activity> getActivities(
            Integer channel,
            Integer type,
            Integer status,
            Integer page,
            Integer pageSize
    ) {
        PageHelper.startPage(page, pageSize);
        List<Activity> list = activityMapper.getActivities(channel, type, status);
        PageInfo<Activity> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Activity> getActivitiesByType(Integer type) {
        return activityMapper.getActivitiesByType(type);
    }
}
