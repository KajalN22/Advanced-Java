package com.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.std.entities.Student;

public interface StudentService {

	String addNewStudent(Student newStudent,Long course_Id);
	
	String cancelAdmission(Long courseId,Long studentId);
	
	List<Student> findByCourseCourseTitle(String courseTitle);
	
	Student updateStudentDetails(Student student);
	
}
