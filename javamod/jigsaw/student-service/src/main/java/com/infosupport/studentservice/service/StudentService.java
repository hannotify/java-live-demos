package com.infosupport.studentservice.service;

import com.infosupport.studentservice.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> retrieveStudents();
    int retrieveTotalStudentDebt();
}
