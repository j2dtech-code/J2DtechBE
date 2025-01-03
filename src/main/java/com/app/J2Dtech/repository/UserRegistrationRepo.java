package com.app.J2Dtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.J2Dtech.entity.UserRegistration;

@Repository
public interface UserRegistrationRepo extends JpaRepository<UserRegistration, Long> {

	@Query(value = "select * from User_Registration where email = :email", nativeQuery = true)
	UserRegistration getUserDataByEmail(@Param("email") String email);

}
