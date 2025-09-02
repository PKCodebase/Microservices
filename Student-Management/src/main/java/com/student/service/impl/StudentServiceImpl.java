package com.student.service.impl;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student added Successfully";
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public String deleteStudentById(Long id) {
       Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
       studentRepository.delete(student);
        return "Student deleted successfully";
    }

    @Override
    public Student getStudentById(Long id) {
       Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
        return student;
    }
}
