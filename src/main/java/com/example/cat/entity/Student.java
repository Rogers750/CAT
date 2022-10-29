package com.example.cat.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="studentName")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="rollNo", unique = true)
    private int rollNo;
   
}
