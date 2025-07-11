package com.app.J2Dtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.J2Dtech.entity.UserRegistration;

import jakarta.transaction.Transactional;

@Repository
public interface UserRegistrationRepo extends JpaRepository<UserRegistration, Long> {

	@Query(value = "select * from User_Registration where email = :email", nativeQuery = true)
	UserRegistration getUserDataByEmail(@Param("email") String email);
	

	@Modifying
	@Transactional
	@Query(value = "update User_Registration set password = :password where email = :email", nativeQuery = true)
	void updatePassword(@Param("email") String email,@Param("password") String password);
	
	@Query(value = "select * from User_Registration where Phone_Number = :number", nativeQuery = true)
	UserRegistration getUserDataByNumber(@Param("number") String number);
}
