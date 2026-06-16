package com.qk.mapper;

import com.qk.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    /**
     * 新增课程
     *
     * @param course
     */
    void addCourse(Course course);

    /**
     * 删除课程
     *
     * @param id
     */
    @Delete("delete from course where id = #{id}")
    void deleteCourseById(Integer id);

    /**
     * 更新课程
     *
     * @param course
     */
    void updateCourse(Course course);

    /**
     * 根据 id 查询课程
     *
     * @param id
     * @return
     */
    @Select("select id, name, subject, target, price, description, create_time, update_time from course where id = #{id}")
    Course getCourseById(Integer id);

    /**
     * 课程列表（带分页）
     *
     * @param name    课程名称
     * @param subject 课程学科
     * @param target  适用人群
     * @return
     */
    List<Course> getCourses(String name, Integer subject, Integer target);

    /**
     * 查询所有课程
     *
     * @return
     */
    @Select("select id, name, subject, target, price, description, create_time, update_time from course")
    List<Course> getAllCourses();

    /**
     * 根据学科查询课程
     *
     * @param subject 学科id
     * @return
     */
    @Select("select id, name, subject, target, price, description, create_time, update_time from course where subject = #{subject}")
    List<Course> getCoursesBySubject(Integer subject);
}
