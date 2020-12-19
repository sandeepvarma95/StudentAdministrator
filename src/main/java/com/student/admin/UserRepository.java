package com.student.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT s FROM User s where s.email = ?1")
	User findByEmail(String email);
}
