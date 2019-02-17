package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.dataobject.Course;
import com.example.demo.service.impl.CourseServiceImpl;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @ResponseBody
    @CrossOrigin
    @GetMapping(value = "/api/admin/course", produces = "application/json; charset=UTF-8")
    public List<Course> getAllCourses(){
        return courseService.findAll();
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/admin/course/delete", produces = "application/json; charset=UTF-8")
    public ResultVO delCourse(@RequestBody Map<String, String> map) {
        ResultVO resultVO = new ResultVO();
        String cno = map.get("cno");
        try {
            courseService.delCourse(cno);
        } catch (SQLIntegrityConstraintViolationException e) {
            resultVO.setCno(cno);
            resultVO.setCode(500);
            resultVO.setMsg("有学生正在学习这门课程，不能删除");
            return resultVO;
        } catch (Exception e) {
            resultVO.setCno(cno);
            resultVO.setCode(500);
            resultVO.setMsg("有学生正在学习这门课程，不能删除");
            return resultVO;
        }
        resultVO.setCno(cno);
        resultVO.setCode(200);
        resultVO.setMsg("删除成功");
        return resultVO;
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/admin/course/add", produces = "application/json; charset=UTF-8")
    public ResultVO addCourse(@RequestBody Map<String,String> map){
        Course course = new Course();
        course.setCno(map.get("cno"));
        course.setCname(map.get("cname"));
        course.setCredit(Integer.parseInt(map.get("credit")));
        course.setTname(map.get("tname"));
        course.setCdept(map.get("cdept"));
        courseService.addCourse(course);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("添加成功");
        resultVO.setCno(map.get("cno"));
        return resultVO;
    }
}
