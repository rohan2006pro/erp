package com.sgp.erp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgp.erp.model.Student;
import com.sgp.erp.repository.StudentRepository;

@Repository
public class StudentDao {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> findByRegistrationNumber(String registrationNumber) {
        return studentRepository.findByRegistrationNumber(registrationNumber);
    }
}
