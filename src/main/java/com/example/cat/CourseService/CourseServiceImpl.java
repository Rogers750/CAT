package com.example.cat.CourseService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.cat.DAO.StudentCourseRepo;
import com.example.cat.entity.StudentCourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cat.DAO.CoursesRepo;
import com.example.cat.StundentService.StudentService;
import com.example.cat.entity.Courses;
import com.example.cat.entity.Student;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService 
{
	
	CoursesRepo repo;
	
	@Autowired
	StudentService stuServiceImpl;

	@Autowired
	StudentCourseRepo studentCourseRepo;
	
	@Autowired
	public CourseServiceImpl(CoursesRepo repo) 
	{
		this.repo=repo;
	}



	
	public Courses getCourse(long courseId)
	{
		
		 Optional<Courses>c=repo.findById(courseId);
		 
		 if(c.isEmpty()) 
		 {
			 throw new RuntimeException("this course doesn't exists: "+courseId);
		 }
		 
		 return c.get();
		 
		 
	}


	@Override
	public List<Student> getStudents(long courseId)
	{
		List<StudentCourse> studentCourses =studentCourseRepo.findByCourseId(courseId);
		log.info("list of student and course: "+studentCourses);
		List<Long> studentIds = studentCourses.stream().map(studentCourse -> studentCourse.getStudentId()).collect(Collectors.toList());
		log.info("list of student Ids: " + studentIds);
		return stuServiceImpl.findAllByIds(studentIds);
	}

	

	
	@Override
	public void addStudent(long courseId, Student stu)
	{
		log.info("saving student: " + stu.toString());
		Student student=  new Student();
		student=stuServiceImpl.saveStudent(stu);
				
		studentCourseRepo.save(StudentCourse.builder()
						.studentId(student.getId())
						.courseId(courseId)
				.build());
	}

	@Override
	public void deleteStudent(int courseId, String email) {

	}

	@Override
	public void changeCourse(Student student, int currCourseId, String newCourseName) {

	}

	@Override
	public Student getStudent(int courseId, String email) {
		return null;
	}


//	@Override
//	public void deleteStudent(int courseId,String email)
//	{
//
//		Optional<Courses>c=repo.findById(courseId);
//		Courses courses= c.get();
//
//
//	    for(Student s: courses.getStudents())
//	    {
//	    	if(s.getEmail()==email)
//	    	{
//	    		courses.removeStudent(s);
//	    	}
//	    }
//	}
	
//	@Override
//	public Student getStudent(int courseId, String email)
//	{
//
//		Optional<Courses> c=repo.findById(courseId);
//		Courses course=c.get();
//
//		for(Student s: course.getStudents())
//		{
//			if(s.getEmail()==email)
//			{
//				return s;
//			}
//			else
//			{
//				throw new RuntimeException("Student with email: "+email+" doesn't exist in course: "+course.getCourseName());
//			}
//		}
//
//		return null;
//	}
	

//	@Override
//	public void changeCourse(Student student, int currCourseId, String courseName)
//	{
//		    List<Courses> courses=findAll();
//            Optional<Courses> c=repo.findById(currCourseId);
//            Courses course=c.get();
//            course.removeStudent(student);
//
//            for(Courses c2: courses)
//            {
//            	if(c2.getCourseName()==courseName)
//            	{
//            		c2.addStudent(student);
//            	}
//            	else {
//            		throw new RuntimeException("this course doesn't exists");
//            	}
//            }
//
//
//	}

  
	
	@Override
	public Courses save(Courses course) {
		return repo.save(course);
	}

	@Override
	public void setTotal(Courses course) {

	}


	@Override
	public List<Courses> findAll() {
		List<Courses> courses= repo.findAll();
		//courses.stream().forEach(course ->course.setTotalStudents());
		log.info("=======================");
		log.info(courses.toString());
		return courses;
	}


	
	
	
	
	
	

}
