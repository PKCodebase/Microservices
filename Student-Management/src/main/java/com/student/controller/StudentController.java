package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(Student student){
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll()
    {
        List<Student> student = studentService.getAllStudent();
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }
}
