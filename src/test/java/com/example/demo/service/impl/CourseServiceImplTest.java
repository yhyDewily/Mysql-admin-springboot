package com.example.demo.service.impl;

import com.example.demo.dataobject.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceImplTest {

    @Autowired
    CourseServiceImpl courseService;

    @Test
    public void findAll() {
        List<Course> courses = courseService.findAll();
        Assert.assertNotEquals(0, courses.size());
    }

    @Test
    public void deleteTest(){
        String cno = "C2";
        try {
            courseService.delCourse(cno);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addOneTest(){
        Course course = new Course();
        course.setCno("C10");
        course.setCname("概率论");
        course.setCdept("计算机应用");
        course.setCredit(4);
        course.setTname("刘德华");
        courseService.addCourse(course);
    }
}