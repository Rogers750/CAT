package com.example.cat.Service;

import java.util.List;

import com.example.cat.Entity.CourseEntity;
import com.example.cat.Entity.StudentEntity;

public interface CourseService {

	public CourseEntity getCourse(int id);
	
	public List<CourseEntity> getAllCourses();
	
	public List<StudentEntity> getAllStudents(int id);
	
	public CourseEntity addNewStudent(int id, StudentEntity student);
	
	public CourseEntity saveCourse(CourseEntity course);
	
	public CourseEntity removeStudent(int courseId, StudentEntity student);
}
