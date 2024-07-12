package com.std.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.std.entities.Course;
import com.std.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@PostMapping
	public Course addNewCourse(@RequestBody Course course) {
		System.out.println("in add new course"+course);
		return courseService.addNewCourse(course);
		
	}
	
	//Update course fees
	@PutMapping("/{courseId}/fees/{fees}")
	public ResponseEntity<String> updateCurseDetails(@PathVariable("courseId") Long courseId,@PathVariable("fees")double fees){
		String response=courseService.updateCurseDetails(courseId,fees);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/remove-course")
	public void removeCourse(@RequestBody Course course) {
	    courseService.removeCourse(course);
	}

	
}
