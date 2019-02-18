package com.example.demo.service.impl;

import com.example.demo.dataobject.StudentsCourse;
import com.example.demo.repository.StudentsCourseRepository;
import com.example.demo.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentsCourseRepository repository;

    @Override
    public List<StudentsCourse> findByCno(String cno) {
        return repository.findByCno(cno);
    }

    @Override
    public List<StudentsCourse> findAll() {
        return repository.findAll();
    }

    @Override
    public StudentsCourse findBySnoAndCno(String sno, String cno) {
        return repository.findBySnoAndCno(sno, cno);
    }

    @Override
    public void updateGrade(int grade, String sno, String cno) {
        repository.updateGradeBySnoAndAndCno(grade, sno, cno);
    }

    @Override
    public void addGrade(int grade, String sno, String cno) {
        StudentsCourse studentsCourse = new StudentsCourse();
        studentsCourse.setSno(sno);
        studentsCourse.setCno(cno);
        studentsCourse.setGrade(grade);
        repository.save(studentsCourse);
    }
}
