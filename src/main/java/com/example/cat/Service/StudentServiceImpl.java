package com.example.cat.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cat.DAO.StudentsRepo;
import com.example.cat.Entity.CourseEntity;
import com.example.cat.Entity.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService {

	StudentsRepo sturepo;
	
	@Autowired
	public StudentServiceImpl(StudentsRepo sturepo) {
		this.sturepo=sturepo;
	}

	@Override
	public StudentEntity getStudentById(int id) {
		Optional<StudentEntity> student=sturepo.findById(id);
		if(student.isEmpty()) throw new RuntimeException("this student with id: "+id+" is not present");
		return student.get();
	}

	@Override
	public StudentEntity saveStudent(StudentEntity student) {
		return sturepo.save(student);
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		
		return sturepo.findAll();
	}

	@Override
	public StudentEntity mapCourseToStudent(StudentEntity student, CourseEntity course) {
		student.getCourses().add(course);
		return sturepo.save(student);
	}
	
	
	
	
}
