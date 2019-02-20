package com.example.demo.service.impl;

import com.example.demo.dataobject.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addOne(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delOne(String sno) {
        Student student = studentRepository.getOne(sno);
        studentRepository.delete(student);
    }
}
