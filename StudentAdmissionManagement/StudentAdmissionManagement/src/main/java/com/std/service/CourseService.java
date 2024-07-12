package com.std.service;

import com.std.entities.Course;

public interface CourseService {

	Course addNewCourse(Course addNewCourse);
	
	String updateCurseDetails(Long courseId,double fees);
	
  void removeCourse(Course course);
}
