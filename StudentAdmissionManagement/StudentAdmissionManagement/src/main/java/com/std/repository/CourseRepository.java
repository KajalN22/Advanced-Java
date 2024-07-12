package com.std.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.std.entities.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseTitle(String courseTitle);
    
    
}
