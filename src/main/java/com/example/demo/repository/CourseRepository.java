package com.example.demo.repository;

import com.example.demo.dataobject.Course;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
}