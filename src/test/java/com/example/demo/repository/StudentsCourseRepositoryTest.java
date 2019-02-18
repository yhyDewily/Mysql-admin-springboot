package com.example.demo.repository;

import com.example.demo.dataobject.StudentsCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentsCourseRepositoryTest {

    @Autowired
    StudentsCourseRepository repository;

    @Test
    public void findByCnoTest() {
        List<StudentsCourse> courses = repository.findByCno("C1");
        for (int i=0;i<courses.size();i++){
            System.out.println(courses.get(i));
        }
    }

    @Test
    public void findBySnoAndCnoTest() {
        if(repository.findBySnoAndCno("S1", "C1") == null)
            System.out.println(true);
    }

}