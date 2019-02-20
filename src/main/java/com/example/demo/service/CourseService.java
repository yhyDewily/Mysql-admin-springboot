package com.example.demo.service;

import com.example.demo.dataobject.Course;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public interface CourseService {

    List<Course> findAll();

    void addCourse(Course course);

    void delCourse(String cno) throws InvocationTargetException, SQLIntegrityConstraintViolationException;

}
