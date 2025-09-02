package com.student.service.impl;

import com.student.client.CourseClient;
import com.student.dto.CourseResponse;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private  final CourseClient courseClient;

    public StudentServiceImpl(StudentRepository studentRepository, CourseClient courseClient) {
        this.studentRepository = studentRepository;
        this.courseClient = courseClient;
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
        return studentRepository.findById(id)
                 .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public Student updateStudentById(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(()->{
                    return new RuntimeException("Student Not Found");
                });
        existingStudent.setName(student.getName());
        existingStudent.setcId(student.getcId());
        return studentRepository.save(existingStudent);
    }
    @Override
    public CourseResponse getCourseForStudent(Long cId) {
        return courseClient.getCourseById(cId);
    }

}
