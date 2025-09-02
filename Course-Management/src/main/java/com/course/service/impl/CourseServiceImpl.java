package com.course.service.impl;

import com.course.entity.Course;
import com.course.repository.CourseRepository;
import com.course.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public String addCourse(Course course) {
        courseRepository.save(course);
        return "Course Added Successfully : ";
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(Long id) {
        return  courseRepository.findById(id)
                .orElseThrow(()-> { return new RuntimeException("Course not found : "+id);
                });

    }

    @Override
    public String deleteCourseById(Long id) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Course not found : "+id));
        courseRepository.delete(existingCourse);
        return "Course deleted Successfully ";
    }

    @Override
    public Course updateCourseById(Long id, Course course) {

        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(()->{return new RuntimeException("Course not found : "+id);
                });
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setPrice(course.getPrice());
        return courseRepository.save(existingCourse);

    }
}
