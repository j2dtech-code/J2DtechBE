package com.app.J2Dtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.J2Dtech.entity.InstructorRegistration;

@Repository
public interface InstructorRegistrationRepo extends JpaRepository<InstructorRegistration, Long>{

}
