package com.example.cat.courseController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cat.CourseService.CourseService;
import com.example.cat.entity.Courses;
import com.example.cat.entity.Student;

@RestController
@RequestMapping("/api")
public class courseController 
{
	
	CourseService courseService;
	Courses course1=new Courses("course1");
	Courses course2=new Courses("course2");
	
	Student stu1=new Student("sagar","sagarsinghraw77@gmail.com",123) ;
	Student stu2=new Student("shubham","shubham@gmail.com",90);
	
	@Autowired
	public courseController(CourseService serv) 
	{
		this.courseService=serv;
	}
	
	public Courses addCourse(String name, String email, int roll, String courseName) {
		Courses course=new Courses("course1");
		
		course.addStudent(new Student(name,email,roll));
		
		return course;
	}
	
	public void insertCourses() {
		course1=courseService.save(course1);
		course2=courseService.save(course2);
		courseService.addStudent(course1.getId(),stu1);
		courseService.addStudent(course2.getId(), stu2);
        courseService.save(course1);
		courseService.save(course2);
//		course1.addStudent(new Student("sagar","sagarsinghraw77@gmail.com",123));
//		course1.addStudent(new Student("surli","surli_surleshwar@gmail.com",124));
//		
//		course2.addStudent(new Student("vishal","vishal@gmail.com",89));
//		course2.addStudent(new Student("shubham","shubham@gmail.com",90));
		
		
		
	}
	
  
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		insertCourses();
		return courseService.findAll();
	}
	
	@GetMapping("/courses/{courseId}")
	public List<Student> getStudents(@PathVariable int courseId)
	{
		return courseService.getStudents(courseId);
	}
	
	@PostMapping("/courses/{courseId}/newStudent") //(not complete)
	public Student addStudent(@PathVariable int courseId, @RequestBody Student stu) 
	{
		 courseService.addStudent(courseId, stu);
		 
		 //can redirect to main course page
		 return stu;
	}
	
	
	@DeleteMapping("/courses/{courseId}/{studentEmail}")
	public Student deleteStudent(@PathVariable int courseId, @PathVariable String studentEmail) 
	{
		Student st=courseService.getStudent(courseId, studentEmail);
		 courseService.deleteStudent(courseId, studentEmail);
		 return st;
	}
}
