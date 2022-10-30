package com.example.cat.StundentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cat.DAO.StudentRepo;
import com.example.cat.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo stuRepo;
	
	@Override
	public List<Student> getAll() {
		
		return stuRepo.findAll();
	}

	@Override
	public List<Student> saveStudents(List<Student> students) {
		return stuRepo.saveAll(students);
	}

	@Override
	public Student saveStudent(Student student) {
		
		return stuRepo.save(student);
	}

	@Override
	public Student getStudent(long id){
		Optional<Student> optionalStudent = stuRepo.findById(id);
		if(optionalStudent.isEmpty()) throw new RuntimeException("student not found with id: "+id);
		return optionalStudent.get();
	}

	@Override
	public List<Student> findAllByIds(List<Long> ids) {
		return stuRepo.findAllById(ids);
	}

}
