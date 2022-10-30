package com.example.cat.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cat.Entity.StudentEntity;

public interface StudentsRepo extends JpaRepository<StudentEntity, Integer> {

}
