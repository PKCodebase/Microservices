package com.student.service;

import com.student.entity.Student;

import java.util.List;

public interface StudentService {

    String addStudent(Student student);

    List<Student> getAllStudent();

    String deleteStudentById(Long id);

    Student getStudentById(Long id);
}
