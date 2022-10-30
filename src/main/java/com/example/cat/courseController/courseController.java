package com.example.cat.CourseController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cat.Entity.CourseEntity;
import com.example.cat.Entity.StudentEntity;
import com.example.cat.Service.CourseServiceImpl;
import com.example.cat.Service.StudentServiceImpl;

@RestController
@RequestMapping("/api")
<<<<<<< HEAD
public class CourseController {
     
	CourseServiceImpl courseService;
	
	StudentServiceImpl studentService;
=======
@Slf4j
public class courseController 
{

	CourseService courseService;
>>>>>>> 6049a18d84da2f66effc48986dc1af7dfaef142a
	
	@Autowired
	public CourseController(CourseServiceImpl courseService, StudentServiceImpl studentService) {
		this.courseService=courseService;
		this.studentService=studentService;
	}
<<<<<<< HEAD
	
	@GetMapping("/students")
	public List<StudentEntity> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{studentId}")
	public StudentEntity getStudentById(@PathVariable int studentId) {
		return studentService.getStudentById(studentId);
	}
	
	@PostMapping("/students/save")
	public StudentEntity saveStudent(@RequestBody StudentEntity student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/courses")
	public List<CourseEntity> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public CourseEntity getAllCourses(@PathVariable int courseId) {
		return courseService.getCourse(courseId);
	}
	
	@PostMapping("/courses/save")
	public CourseEntity saveCourse(@RequestBody CourseEntity course) {
		return courseService.saveCourse(course);
	}
	
	@PostMapping("/courses/{courseId}/saveStudent")
	public StudentEntity addCourseStudent(@PathVariable int courseId, @RequestBody  StudentEntity student) {
		 StudentEntity stu=studentService.saveStudent(student);
		 CourseEntity c= courseService.addNewStudent(courseId, stu);
		// studentService.mapCourseToStudent(student, c);
=======

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
>>>>>>> 6049a18d84da2f66effc48986dc1af7dfaef142a
		 return stu;
	}
	
	@GetMapping("/courses/{courseId}/students")
	public List<StudentEntity> getCourseStudents(@PathVariable int courseId){
		CourseEntity course=courseService.getCourse(courseId);
		return course.getStudents();
	}
	
<<<<<<< HEAD
	@PutMapping("/courses/{courseId}/{studentId}")
	public CourseEntity removeStudentFromCourse(@PathVariable int courseId, @PathVariable int studentId) {
		StudentEntity student=studentService.getStudentById(studentId);
		return courseService.removeStudent(courseId, student);
	}
	
	@PutMapping("/courses/{currCourseId}/{studentId}/{newCourseId}")
	public CourseEntity changeStudentCourse(@PathVariable int currCourseId, @PathVariable int studentId,@PathVariable int newCourseId) {
		StudentEntity student=studentService.getStudentById(studentId);
		courseService.removeStudent(currCourseId, student);
		 return courseService.addNewStudent(newCourseId, student);
=======
	@DeleteMapping("/courses/{courseId}/{studentEmail}")
	public Student deleteStudent(@PathVariable int courseId, @PathVariable String studentEmail)
	{
		Student st=courseService.getStudent(courseId, studentEmail);
		 courseService.deleteStudent(courseId, studentEmail);
		 return st;
>>>>>>> 6049a18d84da2f66effc48986dc1af7dfaef142a
	}
}
