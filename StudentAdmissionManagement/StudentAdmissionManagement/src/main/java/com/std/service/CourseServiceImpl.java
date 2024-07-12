package com.std.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.entities.Course;
import com.std.repository.CourseRepository;
import com.std.repository.StudentRepository;
@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Course addNewCourse(Course addNewCourse) {
		
		return  courseRepository.save(addNewCourse);
	}

	@Override
	public String updateCurseDetails(Long courseId,double fees) {
		Optional <Course> optionalCourse=courseRepository.findById(courseId);
		if(optionalCourse.isPresent()) {
			Course c=optionalCourse.get();
			c.setFees(fees);
			courseRepository.save(c);
			return "Course fees updated Successfully";
		}
		return "Course not found";	
	}

	@Override
	public void removeCourse(Course course) {
		courseRepository.delete(course);
		
	}

	
	
	
}
