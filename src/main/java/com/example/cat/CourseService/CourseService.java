package com.example.cat.CourseService;

import java.util.List;

import com.example.cat.entity.Courses;
import com.example.cat.entity.Student;

public interface CourseService {
    
   public List<Courses> findAll();
   public List<Student> getStudents(int courseId); //(done)
  
   public void addStudent(int courseId, Student stu); //(done)
   public void deleteStudent(int courseId,String email); //(done)  
   public void changeCourse(Student student, int currCourseId, String newCourseName); //(done)
   
   public Student getStudent(int courseId, String email);
   
   public Courses save(Courses course);
   
   public void setTotal(Courses course);
 
}
