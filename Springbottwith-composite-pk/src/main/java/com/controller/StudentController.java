package com.controller;



	import com.entity.Students;
	import com.service.Student;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/students")
	public class StudentController {

	    @Autowired
	    private Student studentsService;

	    // Get all students
	    @GetMapping
	    public List<Students> getAllStudents() {
	        return studentsService.getAllStudents();
	    }

	    // Get student by ID
	    @GetMapping("/{sid}")
	    public ResponseEntity<Students> getStudentById(@PathVariable int sid) {
	        return studentsService.getStudentById(sid)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Create a new student
	    @PostMapping
	    public Students createStudent(@RequestBody Students student) {
	        return studentsService.createStudent(student);
	    }

	    // Update a student
	    @PutMapping("/{sid}")
	    public ResponseEntity<Students> updateStudent(@PathVariable int sid, @RequestBody Students studentDetails) {
	        return ResponseEntity.ok(studentsService.updateStudent(sid, studentDetails));
	    }

	    // Delete a student
	    @DeleteMapping("/{sid}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable int sid) {
	        studentsService.deleteStudent(sid);
	        return ResponseEntity.noContent().build();
	    }
	}

