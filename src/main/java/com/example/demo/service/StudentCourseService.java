package com.example.demo.service;

import com.example.demo.dataobject.StudentsCourse;


import java.util.List;

public interface StudentCourseService {

    List<StudentsCourse> findByCno(String cno);

    List<StudentsCourse> findAll();

    StudentsCourse findBySnoAndCno(String sno, String cno);

    void updateGrade(int grade, String sno, String cno);

    void addGrade(int grade, String sno, String cno);
}
