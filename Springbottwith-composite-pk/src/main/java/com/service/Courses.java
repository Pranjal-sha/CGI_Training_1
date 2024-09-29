package com.service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.repository.CoursesRepo;

import java.util.List;
	import java.util.Optional;

	@Service
	public class Courses {

	    @Autowired
	    private CoursesRepo coursesRepository;

	    // Get all courses
	    public List<com.entity.Courses> getAllCourses() {
	        return coursesRepository.findAll();
	    }

	    // Get course by ID
	    public Optional<com.entity.Courses> getCourseById(int cid) {
	        return coursesRepository.findById(cid);
	    }

	    // Create a new course
	    public com.entity.Courses createCourse(com.entity.Courses course) {
	        return coursesRepository.save(course);
	    }

	    // Update a course
	    public com.entity.Courses updateCourse(int cid, com.entity.Courses courseDetails) {
	        com.entity.Courses course = coursesRepository.findById(cid)
	                .orElseThrow(() -> new RuntimeException("Course not found"));
	        course.setCname(courseDetails.getCname());
	        return coursesRepository.save(course);
	    }

	    private String getCname() {
			// TODO Auto-generated method stub
			return null;
		}

		// Delete a course
	    public void deleteCourse(int cid) {
	        coursesRepository.deleteById(cid);
	    }
	}


