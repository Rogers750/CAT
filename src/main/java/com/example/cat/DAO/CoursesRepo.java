package com.example.cat.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cat.entity.Courses;

public interface CoursesRepo extends JpaRepository<Courses, Long> {

//	public Courses findByName(String name);
}
