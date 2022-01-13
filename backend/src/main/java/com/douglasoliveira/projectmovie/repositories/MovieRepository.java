package com.douglasoliveira.projectmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasoliveira.projectmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
}
