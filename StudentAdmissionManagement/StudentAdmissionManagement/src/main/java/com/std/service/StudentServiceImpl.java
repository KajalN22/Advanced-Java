package com.std.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.entities.Student;
import com.std.repository.CourseRepository;
import com.std.repository.StudentRepository;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepo;
	
	@Override
	public String addNewStudent(Student newStudent, Long courseId) {
	    if (newStudent.getScore() >= newStudent.getCourseid().getMinScore())  {
	        studentRepository.save(newStudent);
	        return "Admission granted";
	    }	
	    return "Admission denied";
	}

	//delete student admission
	@Override
	public String cancelAdmission(Long courseId, Long studentId) {
		Optional<Student> optionalStudent=studentRepository.findById(studentId);
		if(optionalStudent.isPresent()) {
			Student s=optionalStudent.get();
			if (s.getCourseid().equals(courseId)) {
				studentRepository.delete(s);
				return "Student admission cancelled successfully";
			}else {
				return "student not enrolled in specified course";
			}
		}
		return "student not found";
	}

	//update student details
	@Override
	public Student updateStudentDetails(Student student) {
		
		return studentRepository.save(student);
	}

	public List<Student> findByCourseCourseTitle(String courseTitle) {
        return studentRepository.findByCourseCourseTitle(courseTitle);
    }

	
	
	
	


	
	
	

	
}
