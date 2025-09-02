package com.course.controller;

import com.course.entity.Course;
import com.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllCourse() {
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    @GetMapping("/getById/{id}")
    public  ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(courseService.getById(id));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id,@RequestBody Course course){
        try {
            return ResponseEntity.ok(courseService.updateCourseById(id,course));
        }catch(RuntimeException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(courseService.deleteCourseById(id));
        } catch (RuntimeException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
