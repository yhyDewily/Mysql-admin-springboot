package com.example.demo.VO;

import com.example.demo.dataobject.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultVO {

    private String cno;

    private Integer code;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("course")
    Course course;
}
