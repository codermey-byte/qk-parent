package com.qk.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Course;
import com.qk.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 新增课程
     *
     * @param course
     */
    @PostMapping("/courses")
    public Result addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return Result.success();
    }

    /**
     * 删除课程
     *
     * @param id
     */
    @DeleteMapping("/courses/{id}")
    public Result deleteCourseById(@PathVariable Integer id) {
        courseService.deleteCourseById(id);
        return Result.success();
    }

    /**
     * 更新课程
     *
     * @param course
     */
    @PutMapping("/courses")
    public Result updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return Result.success();
    }

    /**
     * 根据 id 查询课程
     *
     * @param id
     * @return
     */
    @GetMapping("/courses/{id}")
    public Result getCourseById(@PathVariable Integer id) {
        Course course = courseService.getCourseById(id);
        return Result.success(course);
    }

    /**
     * 课程列表
     *
     * @param name     课程名称
     * @param subject  课程学科
     * @param target   适用人群
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/courses")
    public Result getCourses(
            String name,
            Integer subject,
            Integer target,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageResult<Course> courses = courseService.getCourses(name, subject, target, page, pageSize);
        return Result.success(courses);
    }

    /**
     * 查询所有课程
     *
     * @return
     */
    @GetMapping("/courses/list")
    public Result getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return Result.success(courses);
    }

    /**
     * 根据学科查询课程
     *
     * @param subject
     * @return
     */
    @GetMapping("/courses/subject/{subject}")
    public Result getCoursesBySubject(@PathVariable Integer subject) {
        List<Course> courses = courseService.getCoursesBySubject(subject);
        return Result.success(courses);
    }
}
