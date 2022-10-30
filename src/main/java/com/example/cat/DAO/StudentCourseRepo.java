package com.example.cat.DAO;

import com.example.cat.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, Long> {
    public List<StudentCourse> findByCourseId(Long id);
    public List<StudentCourse> findByStudentId(Long id);
}
