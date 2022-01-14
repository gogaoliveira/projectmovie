package com.douglasoliveira.projectmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasoliveira.projectmovie.entities.Score;
import com.douglasoliveira.projectmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
}
