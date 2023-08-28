package com.baidya.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidya.movies.pojo.Movie;
import com.baidya.movies.service.MovieService;
import com.baidya.movies.vo.MovieCast;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public Movie save(@RequestBody Movie movie) {

		return movieService.save(movie);
	}
	
	@GetMapping("/{id}")
	public MovieCast getMovie(@PathVariable("id")long id) {
		return movieService.getMovie(id);
	}
	
	@GetMapping
	public List<Movie> all() {
		return movieService.findAll();
	}

	@GetMapping("/{id}/v2")
	public MovieCast getMovieV2(@PathVariable("id")long id) {
		return movieService.getMovieV2(id);
	}
	
}


