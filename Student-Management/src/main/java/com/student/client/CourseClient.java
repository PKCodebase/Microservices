package com.student.client;

import com.student.dto.CourseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service", url = "http://localhost:8081")
public interface CourseClient {
    @GetMapping("/course/{id}")
    CourseResponse getCourseById(@PathVariable("id") Long id);
}

