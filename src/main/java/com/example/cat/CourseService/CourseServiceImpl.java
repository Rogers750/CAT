package com.example.cat.CourseService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cat.DAO.CoursesRepo;
import com.example.cat.StundentService.StudentService;
import com.example.cat.entity.Courses;
import com.example.cat.entity.Student;

@Service
public class CourseServiceImpl implements CourseService 
{
	
	CoursesRepo repo;
	
	@Autowired
	StudentService stuServiceImpl;
	
	@Autowired
	public CourseServiceImpl(CoursesRepo repo) 
	{
		this.repo=repo;
	}



	
	public Courses getCourse(int courseId) 
	{
		
		 Optional<Courses>c=repo.findById(courseId);
		 
		 if(c.isEmpty()) 
		 {
			 throw new RuntimeException("this course doesn't exists: "+courseId);
		 }
		 
		 return c.get();
		 
		 
	}


	@Override
	public List<Student> getStudents(int courseId)
	{
		Optional<Courses>c=repo.findById(courseId); 
		Courses course=null;
		
		if(c.isEmpty()) {
			throw new RuntimeException("No Course Exists with this id: "+courseId);
		}
		
		course=c.get();
			
		
		return course.getStudents();
	}

	

	
	@Override
	public void addStudent(int courseId, Student stu)
	{
		Student student=  new Student();
				student=stuServiceImpl.saveStudent(stu);
				
				Courses course=null;
				
				System.out.println(student.toString());
		
		List<Courses> c=findAll();
		System.out.println("========================**************");
		System.out.println(c.toString());
		for(Courses cc:c) {
			if(cc.getId()==courseId) {
				course=cc;
				break;
			}
		}
		
		System.out.println("========================FFFFFFFFFFFFFFFFFFFFFFFFFFFF");
		System.out.println(course.toString());
		
		for(Student s:course.getStudents()) {
			System.out.println(s.toString());
			if(s.getId()==student.getId()) {
				return;
			}
		}
		
		course.addStudent(student);
		repo.save(course);
//		Courses course= c.get();
//		
//		for(Student s:course.getStudents()) {
//			if(s.getId()==stu.getId()) {
//				return;
//			}
//		}
//		
//		course.addStudent(student);
//		repo.save(course);
		return;

	}
	

	@Override
	public void deleteStudent(int courseId,String email) 
	{
		
		Optional<Courses>c=repo.findById(courseId); 
		Courses courses= c.get();
	    
	    
	    for(Student s: courses.getStudents()) 
	    {
	    	if(s.getEmail()==email) 
	    	{
	    		courses.removeStudent(s);
	    	}
	    }
	}
	
	@Override
	public Student getStudent(int courseId, String email)
	{
		
		Optional<Courses> c=repo.findById(courseId);
		Courses course=c.get();
		
		for(Student s: course.getStudents())
		{
			if(s.getEmail()==email)
			{
				return s;
			}
			else 
			{
				throw new RuntimeException("Student with email: "+email+" doesn't exist in course: "+course.getCourseName());
			}
		}
		
		return null;
	}
	

	@Override
	public void changeCourse(Student student, int currCourseId, String courseName)
	{
		    List<Courses> courses=findAll();
            Optional<Courses> c=repo.findById(currCourseId);
            Courses course=c.get();
            course.removeStudent(student);
            
            for(Courses c2: courses)
            {
            	if(c2.getCourseName()==courseName) 
            	{
            		c2.addStudent(student);
            	}
            	else {
            		throw new RuntimeException("this course doesn't exists");
            	}
            }
            
            
	}

	
	@Override
	public void setTotal(Courses course) {
		course.setTotalStudents();
		return;
	}

  
	
	@Override
	public Courses save(Courses course) {
		setTotal(course);
		return repo.save(course);	
		
	}




	@Override
	public List<Courses> findAll() {
		List<Courses> courses= repo.findAll();
		//courses.stream().forEach(course ->course.setTotalStudents());
		System.out.println("=======================");
		System.out.println(courses.toString());
		return courses;
	}


	
	
	
	
	
	

}
