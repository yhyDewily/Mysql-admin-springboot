package com.example.demo.repository;

import com.example.demo.dataobject.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @Test
    public void findOneTest() {
        String sno = "S1";
        System.out.println(repository.getOne(sno));
    }


    @Test
    public void findAllTest() {
        List<Student> students = repository.findAll();
        for (int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }
    }
}