package com.service;



	import com.entity.Students;
	import com.repository.StudentRepo;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.List;
	import java.util.Optional;

	@Service
	public class Student {

	    @Autowired
	    private StudentRepo studentsRepository;

	    // Get all students
	    public List<Students> getAllStudents() {
	        return studentsRepository.findAll();
	    }

	    // Get student by ID
	    public Optional<Students> getStudentById(int sid) {
	        return studentsRepository.findById(sid);
	    }

	    // Create a new student
	    public Students createStudent(Students student) {
	        return studentsRepository.save(student);
	    }

	    // Update a student
	    public Students updateStudent(int sid, Students studentDetails) {
	        Students student = studentsRepository.findById(sid)
	                .orElseThrow(() -> new RuntimeException("Student not found"));
	        student.setSname(studentDetails.getSname());
	        return studentsRepository.save(student);
	    }

	    // Delete a student
	    public void deleteStudent(int sid) {
	        studentsRepository.deleteById(sid);
	    }
	}

