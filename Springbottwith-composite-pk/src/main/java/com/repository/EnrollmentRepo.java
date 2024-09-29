package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Enrollment;
import com.entity.EnrollmentKey;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, EnrollmentKey> {

	com.service.Enrollment save(com.service.Enrollment enrollment);

}
