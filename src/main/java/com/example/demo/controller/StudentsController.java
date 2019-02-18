package com.example.demo.controller;

import com.example.demo.dataobject.Student;
import com.example.demo.dataobject.StudentsCourse;
import com.example.demo.service.StudentCourseService;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @Autowired
    StudentCourseService studentCourseService;

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "api/grades/students")
    List<StudentsCourse> getStudentsList(){
        List<StudentsCourse> students = studentCourseService.findAll();
        return students;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/api/grades/studentsId")
    List<String> getStudents() {
        List<String> list = new ArrayList<>();
        List<Student> students = studentsService.findAll();
        for(int i=0;i<students.size();i++){
            list.add(students.get(i).getSno());
        }
        return list;
    }

}
