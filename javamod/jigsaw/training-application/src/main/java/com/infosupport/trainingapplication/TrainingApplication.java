package com.infosupport.trainingapplication;

import com.infosupport.studentservice.service.StudentService;
import com.infosupport.studentservice.service.StudentServiceImpl;

public class TrainingApplication {
    public static void main(String[] args) {
        StudentService s = new StudentServiceImpl();
        s.retrieveStudents();
        s.retrieveTotalStudentDebt();
    }
}