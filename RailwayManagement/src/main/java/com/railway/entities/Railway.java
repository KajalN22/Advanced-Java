package com.railway.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Railway {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    @NotBlank(message="Name is mandatory")
	private  String name;
    @Enumerated(EnumType.STRING)
	private Category category;
    @Past
	private LocalTime start_time;
	private LocalTime end_time;
	@NotBlank(message="Source is mandatory")
    private String source;
	@NotBlank(message="destination is mandatory")
    private String destination;
	@NotBlank(message = "Station code is mandatory")
    @Column(unique = true)
    private String station_code;
    private int distance;
    private int frequency;
    
    
    //No arg constructor
    public Railway() {
		super();
	}
	//constructor 
	public Railway( String name,
			Category category, LocalTime start_time, LocalTime end_time,
			String source,
			String destination,
		    String station_code, int distance,
			int frequency) {
		super();
		this.name = name;
		this.category = category;
		this.start_time = start_time;
		this.end_time = end_time;
		this.source = source;
		this.destination = destination;
		this.station_code = station_code;
		this.distance = distance;
		this.frequency = frequency;
	}
	
    //getters setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}
	public LocalTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Railway [id=" + id + ", name=" + name + ", category=" + category + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", source=" + source + ", destination=" + destination + ", station_code="
				+ station_code + ", distance=" + distance + ", frequency=" + frequency + "]";
	}
    
	
	
    
	
}
