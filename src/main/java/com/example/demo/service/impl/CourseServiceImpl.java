package com.example.demo.service.impl;

import com.example.demo.dataobject.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository repository;

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public void addCourse(Course course) {
        repository.save(course);
    }

    @Override
    public void delCourse(String cno) throws SQLIntegrityConstraintViolationException {
        Course course = repository.getOne(cno);
        repository.delete(course);
    }
}
