package com.example.cat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
   

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
   @Column(name="studentName")
   private String name;
   
   @Column(name="email")
   private String email;
   
   @Column(name="rollNo")
   private int rollNo;
   
   public Student(String  name, String email , int rollNo) {
		this.name=name;
		this.email=email;
		this.rollNo=rollNo;
		
	}
   
   public Student() {
	   
   }
   
}
