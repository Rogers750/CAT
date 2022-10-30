package com.example.cat.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cat.Entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

}
