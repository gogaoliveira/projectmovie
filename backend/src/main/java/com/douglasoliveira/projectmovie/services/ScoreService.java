package com.douglasoliveira.projectmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douglasoliveira.projectmovie.dto.MovieDTO;
import com.douglasoliveira.projectmovie.dto.ScoreDTO;
import com.douglasoliveira.projectmovie.entities.Movie;
import com.douglasoliveira.projectmovie.entities.Score;
import com.douglasoliveira.projectmovie.entities.User;
import com.douglasoliveira.projectmovie.repositories.MovieRepository;
import com.douglasoliveira.projectmovie.repositories.ScoreRepository;
import com.douglasoliveira.projectmovie.repositories.UserRepository;


@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}
	
	
	
}
