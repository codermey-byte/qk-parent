package com.qk.service;

import com.qk.common.PageResult;
import com.qk.entity.Course;

import java.util.List;

public interface CourseService {
    /**
     * 新增课程
     *
     * @param course 课程信息
     */
    void addCourse(Course course);

    /**
     * 删除课程
     *
     * @param id 课程 id
     */
    void deleteCourseById(Integer id);

    /**
     * 更新课程
     *
     * @param course 课程信息
     */
    void updateCourse(Course course);

    /**
     * 根据 id 查询课程
     *
     * @param id
     * @return
     */
    Course getCourseById(Integer id);

    /**
     * 课程列表（带分页）
     *
     * @param name     课程名称
     * @param subject  课程学科
     * @param target   适用人群
     * @param page     页码
     * @param pageSize 每页条数
     * @return
     */
    PageResult<Course> getCourses(String name, Integer subject, Integer target, Integer page, Integer pageSize);

    /**
     * 查询所有课程
     *
     * @return
     */
    List<Course> getAllCourses();

    /**
     * 根据学科查询课程
     *
     * @param subject 学科id
     * @return 当前学科下的课程列表
     */
    List<Course> getCoursesBySubject(Integer subject);
}
