package com.qk.mapper;

import com.qk.entity.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityMapper {
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
    @Delete("DELETE FROM activity WHERE id = #{id}")
    void deleteActivity(Integer id);

    /**
     * 更新活动
     *
     * @param activity
     */
    void updateActivity(Activity activity);

    /**
     * 根据 id 获取活动
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM activity WHERE id = #{id}")
    Activity getActivityById(Integer id);

    /**
     * 活动列表（带分页）
     *
     * @param channel 活动渠道
     * @param type    活动类型
     * @param status  活动状态
     * @return
     */
    List<Activity> getActivities(Integer channel, Integer type, Integer status);


    /**
     * 查询指定类型的活动
     *
     * @param type 活动类型
     * @return
     */
    @Select("select * from activity where type = #{type}")
    List<Activity> getActivitiesByType(Integer type);
}
