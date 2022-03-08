package com.example.springboot.courses.repository;

import com.example.springboot.courses.bean.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
