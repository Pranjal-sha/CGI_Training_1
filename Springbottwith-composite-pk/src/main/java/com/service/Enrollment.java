package com.service;



	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Enrollment;
import com.entity.EnrollmentKey;
import com.repository.EnrollmentRepo;

	@Service
	public class Enrollment {

	    @Autowired
	    private EnrollmentRepo enrollmentRepository;

	    // Get all enrollments
	    public List<Enrollment> getAllEnrollments() {
	        return enrollmentRepository.findAll();
	    }

	    // Get enrollment by ID
	    public Optional<Enrollment> getEnrollmentById(EnrollmentKey ek) {
	        return enrollmentRepository.findById(ek);
	    }

	    // Create a new enrollment
	    public Enrollment createEnrollment(Enrollment enrollment) {
	        return enrollmentRepository.save(enrollment);
	    }

//	    // Update an enrollment
//	    public Enrollment updateEnrollment(EnrollmentKey ek, Enrollment enrollmentDetails) {
//	        Enrollment enrollment = enrollmentRepository.findById(ek)
//	                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
//	        enrollment.setYear(enrollmentDetails.getYear());
//	        enrollment.setStudent(enrollmentDetails.getStudent());
//	        enrollment.setCourse(enrollmentDetails.getCourse());
//	        return enrollmentRepository.save(enrollment);
//	    }

	    // Delete an enrollment
	    public void deleteEnrollment(EnrollmentKey ek) {
	        enrollmentRepository.deleteById(ek);
	    }

		public com.entity.Enrollment createEnrollment(com.entity.Enrollment enrollment) {
			// TODO Auto-generated method stub
	        return enrollmentRepository.save(enrollment);
		}

		public Object updateEnrollment(EnrollmentKey ek, com.entity.Enrollment enrollmentDetails) {
			// TODO Auto-generated method stub
			return null;
		}
	}


