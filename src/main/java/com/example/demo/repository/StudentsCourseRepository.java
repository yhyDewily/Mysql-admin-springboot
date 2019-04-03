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

    @Query(value = "SELECT * FROM demo.sc WHERE CNO=?1", nativeQuery = true)
    List<StudentsCourse> findByCno(String cno);

    @Query(value = "SELECT * FROM demo.sc WHERE SNO=?1 AND CNO=?2", nativeQuery = true)
    StudentsCourse findBySnoAndCno(String sno, String cno);

    @Query(value = "SELECT * FROM demo.sc", nativeQuery = true)
    List<StudentsCourse> findAll();

    @Modifying
    @Transactional
    @Query("update StudentsCourse as sc set grade = ?1  where sc.sno=?2 and sc.cno=?3")
    void updateGradeBySnoAndAndCno(int grade, String sno, String cno);
}
