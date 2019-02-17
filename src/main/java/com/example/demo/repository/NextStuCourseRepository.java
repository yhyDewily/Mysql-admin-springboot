package com.example.demo.repository;


import com.example.demo.dataobject.NextStuCourse;
import com.example.demo.dataobject.SnoCnoMultilKeyClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NextStuCourseRepository extends JpaRepository<NextStuCourse, SnoCnoMultilKeyClass> {

    List<NextStuCourse> findBySno(String sno);

    NextStuCourse findBySnoAndCno(String sno, String cno);

//    void deleteBySnoAndCno (String sno, String cno);
}
