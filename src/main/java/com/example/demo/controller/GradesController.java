package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.dataobject.StudentsCourse;
import com.example.demo.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GradesController {

    @Autowired
    StudentCourseService service;

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/grades/getgrades", produces = "application/json; charset=UTF-8")
    List<StudentsCourse> getGrades(@RequestBody Map<String, String> map){
        String cno = map.get("cno");
        return service.findByCno(cno);
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/grades/update", produces = "application/json; charset=UTF-8")
    ResultVO update(@RequestBody Map<String, String> map){
        String sno = map.get("sno");
        String cno = map.get("cno");
        int grade = Integer.parseInt(map.get("grade"));
        ResultVO resultVO = new ResultVO();
        if(service.findBySnoAndCno(sno, cno) == null){
            try {
                service.addGrade(grade, sno, cno);
            } catch (Exception e) {
                resultVO.setCno(cno);
                resultVO.setMsg("添加失败");
                resultVO.setCode(500);
                return resultVO;
            }
        } else {
            try {
                service.updateGrade(grade,sno,cno);
            } catch (Exception e) {
                resultVO.setCno(cno);
                resultVO.setMsg("添加失败");
                resultVO.setCode(500);
                return resultVO;
            }
        }
        resultVO.setCode(200);
        resultVO.setMsg("添加成功");
        resultVO.setCode(200);
        return resultVO;
    }
}
