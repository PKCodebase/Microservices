package com.student.dto;

import lombok.Data;

@Data
public class CourseResponse {

    private Long cId;

    private String courseName;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
