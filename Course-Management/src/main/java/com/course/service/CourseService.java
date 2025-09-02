package com.course.service;

import com.course.entity.Course;

import java.util.List;

public interface CourseService {

    String addCourse(Course course);

    List<Course> getAllCourse();

    Course getById(Long id);

    String deleteCourseById(Long id);

    Course updateCourseById(Long id,Course course);
}
