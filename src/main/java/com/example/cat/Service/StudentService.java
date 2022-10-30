package com.example.cat.Service;

import java.util.List;

import com.example.cat.Entity.CourseEntity;
import com.example.cat.Entity.StudentEntity;

public interface StudentService {

	public StudentEntity getStudentById(int id);
	
	public StudentEntity saveStudent(StudentEntity student);
	
	public List<StudentEntity> getAllStudents();
	
	public StudentEntity mapCourseToStudent(StudentEntity student, CourseEntity course);
}
