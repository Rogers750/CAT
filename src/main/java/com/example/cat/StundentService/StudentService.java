package com.example.cat.StundentService;

import java.util.List;

import com.example.cat.entity.Student;

public interface StudentService {
  public List<Student> getAll();
  public List<Student> saveStudents(List<Student> students);
  public Student saveStudent(Student student);

  public Student getStudent(long id);

  public List<Student> findAllByIds(List<Long> ids);
}
