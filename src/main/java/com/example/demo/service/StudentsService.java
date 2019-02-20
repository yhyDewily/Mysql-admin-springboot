package com.example.demo.service;

import com.example.demo.dataobject.Student;

import java.util.List;

public interface StudentsService {

    List<Student> findAll();

    void addOne(Student student);

    void delOne(String sno);
}
