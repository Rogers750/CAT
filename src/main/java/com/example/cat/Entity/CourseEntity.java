package com.example.cat.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Courses")
@Data
public class CourseEntity {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="course_Name")
	private String courseName;
	
	@ManyToMany(targetEntity=StudentEntity.class)
	private List<StudentEntity> students;
}
