package com.douglasoliveira.projectmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasoliveira.projectmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
}
