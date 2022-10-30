package com.example.cat.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cat.DAO.CourseRepo;
import com.example.cat.Entity.CourseEntity;
import com.example.cat.Entity.StudentEntity;

@Service
public class CourseServiceImpl implements CourseService {

	CourseRepo courserepo;
	
	
	
	@Autowired
	public CourseServiceImpl(CourseRepo courserepo) {
		this.courserepo=courserepo;
	}

	@Override
	public CourseEntity getCourse(int id) {
		Optional<CourseEntity> c=courserepo.findById(id);
		if(c.isEmpty()) throw new RuntimeException("this course doesn't exists: "+id);
		return c.get();
	}
	
	@Override
	public List<CourseEntity> getAllCourses(){
		
		return courserepo.findAll();
	}
	
	

	@Override
	public CourseEntity saveCourse(CourseEntity course) {
		return courserepo.save(course);
	
	}

	@Override
	public List<StudentEntity> getAllStudents(int id) {
		Optional<CourseEntity> c=courserepo.findById(id);
		if(c.isEmpty()) throw new RuntimeException("this course doesn't exists: "+id);
		CourseEntity course=c.get();
		return course.getStudents();
	}

	@Override
	public CourseEntity addNewStudent(int id, StudentEntity student) {
		
		Optional<CourseEntity> c=courserepo.findById(id);
		if(c.isEmpty()) throw new RuntimeException("this course doesn't exists: "+id);
		CourseEntity course=c.get();
		
		for(StudentEntity s: course.getStudents()) {
			if(s.getRollNo()==student.getRollNo()) {
			      System.out.println("============================================");
				throw new RuntimeException("this student already exists: "+student.getRollNo());
			}
		}
		
		course.getStudents().add(student);   //check if student is already present
		return courserepo.save(course);
		
	}

	@Override
	public CourseEntity removeStudent(int courseId, StudentEntity student) {
		Optional<CourseEntity> c=courserepo.findById(courseId);
		if(c.isEmpty()) throw new RuntimeException("this course doesn't exists: "+courseId);
		CourseEntity course=c.get();
		
		course.getStudents().remove(student);
		return courserepo.save(course);
	}
	
	
	
}
