package com.controller;

	
	import com.entity.Enrollment;
	import com.entity.EnrollmentKey;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/enrollments")
	public class ErollmentController {

	    @Autowired
	    private com.service.Enrollment enrollmentService;

	    // Get all enrollments
	    @GetMapping
	    public List<com.service.Enrollment> getAllEnrollments() {
	        return enrollmentService.getAllEnrollments();
	    }

	    // Get enrollment by ID
	    @GetMapping("/{sid}/{cid}")
	    public ResponseEntity<com.service.Enrollment> getEnrollmentById(@PathVariable int sid, @PathVariable int cid) {
	        EnrollmentKey ek = new EnrollmentKey();
	        ek.setSid(sid);
	        ek.setCid(cid);
	        return enrollmentService.getEnrollmentById(ek)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Create a new enrollment
	    @PostMapping
	    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
	        return enrollmentService.createEnrollment(enrollment);
	    }

	    // Update an enrollment
	    @PutMapping("/{sid}/{cid}")
	    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable int sid, @PathVariable int cid,
	                                                       @RequestBody Enrollment enrollmentDetails) {
	        EnrollmentKey ek = new EnrollmentKey();
	        ek.setSid(sid);
	        ek.setCid(cid);
	        return ResponseEntity.ok(enrollmentService.updateEnrollment(ek, enrollmentDetails));
	    }

	    // Delete an enrollment
	    @DeleteMapping("/{sid}/{cid}")
	    public ResponseEntity<Void> deleteEnrollment(@PathVariable int sid, @PathVariable int cid) {
	        EnrollmentKey ek = new EnrollmentKey();
	        ek.setSid(sid);
	        ek.setCid(cid);
	        enrollmentService.deleteEnrollment(ek);
	        return ResponseEntity.noContent().build();
	    }
	}

