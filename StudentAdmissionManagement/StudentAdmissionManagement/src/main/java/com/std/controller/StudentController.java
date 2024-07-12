package com.std.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.std.entities.Student;
import com.std.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

@Autowired
private StudentService studentService;

@PostMapping
public ResponseEntity<String> addNewStudent(@RequestBody Student student,@RequestParam Long courseId ) {
	String Response=studentService.addNewStudent(student, courseId);
	return ResponseEntity.ok(Response);
}

//cancel student admission
@DeleteMapping("/{courseId}/students/{studentId}")
public ResponseEntity<String> cancelAdmission(@PathVariable Long courseId,@PathVariable Long studentId){
	String r=studentService.cancelAdmission(courseId, studentId);
	return ResponseEntity.ok(r);
}

//update student details
@PutMapping
public String updateStudentDetails(@RequestBody Student student) {
 studentService.updateStudentDetails(student);
return "Corse deleted successfully";
}

@GetMapping("/student/courseTitle/{courseTitle}")
public ResponseEntity <List<Student>> findByCourseCourseTitle(@PathVariable String courseTitle) {
    List<Student> students = studentService.findByCourseCourseTitle(courseTitle);
    if (students.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(students);
}


}