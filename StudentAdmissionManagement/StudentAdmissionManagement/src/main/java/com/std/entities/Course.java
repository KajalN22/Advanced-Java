package com.std.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long courseId;
	
	@Column(unique = true)
	private  String courseTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
	private int minScore;
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getMinScore() {
		return minScore;
	}
	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}
	public Course(Long courseId, String courseTitle, LocalDate startDate, LocalDate endDate, double fees,
			int minScore) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minScore = minScore;
	}
	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseTitle=" + courseTitle + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fees=" + fees + ", minScore=" + minScore + "]";
	}
	
	public Course() {
	}
	
}
