package com.example.cat.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "courseName", unique=true)
	private String courseName;

	@Column(name = "studentList")
	@OneToMany(targetEntity = Student.class, mappedBy = "id", fetch = FetchType.EAGER)
	private List<Student> students;

	public Courses(String courseName) {
		this.courseName = courseName;
		this.students = new ArrayList<>();
	}

	public Courses() {
		this.students = new ArrayList<>();
	}

	@Column(name = "totalStudents")
	private int totalStudents;

	public void setTotalStudents() {
		this.totalStudents = this.students.size();
	}


	public void addStudent(Student student) {
		 students.add(student);
		
	}

	public void removeStudent(Student stu) {
		for (Student s : students) {
			if (s == stu)
				students.remove(s);
			return;
		}
	}

}
