package com.example.demo.repository;

import com.example.demo.dataobject.SnoCnoMultilKeyClass;
import com.example.demo.dataobject.StudentsCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentsCourseRepository extends JpaRepository<StudentsCourse, SnoCnoMultilKeyClass> {

    List<StudentsCourse> findBySno(String sno);

    List<StudentsCourse> findByCno(String cno);

    StudentsCourse findBySnoAndCno(String sno, String cno);

    List<StudentsCourse> findAll();

    @Modifying
    @Transactional
    @Query("update StudentsCourse as sc set grade = ?1  where sc.sno=?2 and sc.cno=?3")
    void updateGradeBySnoAndAndCno(int grade, String sno, String cno);
}
