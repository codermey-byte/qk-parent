package com.qk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.entity.Course;
import com.qk.mapper.CourseMapper;
import com.qk.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseMapper.deleteCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseMapper.getCourseById(id);
    }

    @Override
    public PageResult<Course> getCourses(
            String name,
            Integer subject,
            Integer target,
            Integer page,
            Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Course> list = courseMapper.getCourses(name, subject, target);
        PageInfo<Course> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }

    @Override
    public List<Course> getCoursesBySubject(Integer subject) {
        return courseMapper.getCoursesBySubject(subject);
    }
}
