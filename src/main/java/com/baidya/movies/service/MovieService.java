package com.baidya.movies.service;

import java.util.List;
import java.util.Optional;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.baidya.movies.pojo.Casting;
import com.baidya.movies.pojo.Movie;
import com.baidya.movies.repository.MovieRepository;
import com.baidya.movies.vo.MovieCast;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository; 
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CastMicroService castMicroService;
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	public MovieCast getMovie(long id) {
		MovieCast movieCast = new MovieCast();
		Optional<Movie> movieOptn = movieRepository.findById(id);
		if(movieOptn.isPresent()) {
			Movie movie = movieOptn.get();
			Casting casting = restTemplate.getForObject("http://CAST/cast/"+movie.getCastId(), Casting.class);
			movieCast.setMovie(movie); 
			movieCast.setCast(casting);
		}
		return movieCast;
	}

	public MovieCast getMovieV2(long id) {
		MovieCast movieCast = new MovieCast();
		Optional<Movie> movieOptn = movieRepository.findById(id);
		if(movieOptn.isPresent()) {
			Movie movie = movieOptn.get();
			Casting casting = castMicroService.find(movie.getCastId());
			movieCast.setMovie(movie);
			movieCast.setCast(casting);
		}
		return movieCast;
	}

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

}
