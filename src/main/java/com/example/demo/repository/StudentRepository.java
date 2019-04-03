package com.example.demo.repository;


import com.example.demo.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query(value = "SELECT * FROM demo.s", nativeQuery = true)
    List<Student> findAll();
}
