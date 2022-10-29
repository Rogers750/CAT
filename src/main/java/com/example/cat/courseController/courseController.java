package com.example.cat.courseController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class courseController 
{

	CourseService courseService;
	
	@Autowired
	public courseController(CourseService serv) 
	{
		this.courseService=serv;
	}

	@PostMapping("/course")
	public Courses addCourse(@RequestBody Courses course){
		log.info("Course to be created: "+course.toString());
		return courseService.save(course);
	}
  
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		return courseService.findAll();
	}
	
	@GetMapping("/courses/{courseId}")
	public List<Student> getStudents(@PathVariable long courseId)
	{
		return courseService.getStudents(courseId);
	}
	
	@PostMapping("/courses/{courseId}/newStudent") //(not complete)
	public Student addStudent(@PathVariable long courseId, @RequestBody Student stu)
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
