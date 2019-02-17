package com.example.demo.service.impl;

import com.example.demo.dataobject.Student;
import com.mysql.cj.jdbc.SuspendableXAConnection;
import org.hibernate.annotations.RowId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentsServiceImplTest {

    @Autowired
    StudentsServiceImpl studentsService;


    @Test
    public void findAllTest() {
        List<Student> students = studentsService.findAll();
        Assert.assertNotEquals(0 ,students.size());
    }
}