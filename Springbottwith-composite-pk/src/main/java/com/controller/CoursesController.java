package com.controller;


	


	import com.entity.Courses;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/courses")
	public class CoursesController {

	    @Autowired
	    private com.service.Courses coursesService;

	    // Get all courses
	    @GetMapping
	    public List<Courses> getAllCourses() {
	        return coursesService.getAllCourses();
	    }

	    // Get course by ID
	    @GetMapping("/{cid}")
	    public ResponseEntity<Courses> getCourseById(@PathVariable int cid) {
	        return coursesService.getCourseById(cid)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Create a new course
	    @PostMapping
	    public Courses createCourse(@RequestBody Courses course) {
	        return coursesService.createCourse(course);
	    }

	    // Update a course
	    @PutMapping("/{cid}")
	    public ResponseEntity<Courses> updateCourse(@PathVariable int cid, @RequestBody Courses courseDetails) {
	        return ResponseEntity.ok(coursesService.updateCourse(cid, courseDetails));
	    }

	    // Delete a course
	    @DeleteMapping("/{cid}")
	    public ResponseEntity<Void> deleteCourse(@PathVariable int cid) {
	        coursesService.deleteCourse(cid);
	        return ResponseEntity.noContent().build();
	    }
	}


