package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.dataobject.Student;
import com.example.demo.dataobject.StudentsCourse;
import com.example.demo.service.StudentCourseService;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @Autowired
    StudentCourseService studentCourseService;

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "api/grades/students")
    public List<StudentsCourse> getStudentsList(){
        List<StudentsCourse> students = studentCourseService.findAll();
        return students;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/api/grades/studentsId")
    public List<String> getStudents() {
        List<String> list = new ArrayList<>();
        List<Student> students = studentsService.findAll();
        for(int i=0;i<students.size();i++){
            list.add(students.get(i).getSno());
        }
        return list;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "api/students/getall")
    public List<Student> getAll() {
        List<Student> students = studentsService.findAll();
        return students;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "api/students/delete")
    public ResultVO delStudent(@RequestBody Map<String,String> map){
        String sno = map.get("studentId");
        ResultVO resultVO = new ResultVO();
        try {
            studentsService.delOne(sno);
        } catch (Exception e){
            resultVO.setCode(500);
            resultVO.setMsg("该学生还有正在学习的课程,不能删除");
            return resultVO;
        }
        resultVO.setCode(200);
        resultVO.setMsg("删除成功");
        return resultVO;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/students/add")
    public ResultVO addStudent(@RequestBody Map<String, String> map){
        Student student = new Student();
        ResultVO resultVO = new ResultVO();
        student.setSno(map.get("sno"));
        student.setSname(map.get("sname"));
        student.setAge(map.get("age"));
        student.setSex(map.get("sex"));
        student.setSdept(map.get("dept"));
        student.setLogn(map.get("logn"));
        student.setPswd(map.get("pswd"));
        studentsService.addOne(student);
        resultVO.setMsg("添加成功");
        resultVO.setCode(200);
        return resultVO;
    }



}
