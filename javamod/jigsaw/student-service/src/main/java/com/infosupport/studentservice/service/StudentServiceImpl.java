package com.infosupport.studentservice.service;

import com.infosupport.studentservice.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static final Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public List<Student> retrieveStudents() {
        LOG.info("Retrieving students!");
        return List.of(new Student("Hanno"),
                new Student("Joep"),
                new Student("Felix"));
    }

    @Override
    public int retrieveTotalStudentDebt() {
        return 42;
    }
}
