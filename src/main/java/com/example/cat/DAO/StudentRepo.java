package com.example.cat.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cat.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
