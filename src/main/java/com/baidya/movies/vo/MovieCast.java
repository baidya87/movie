package com.baidya.movies.vo;

import com.baidya.movies.pojo.Casting;
import com.baidya.movies.pojo.Movie;

public class MovieCast {

	private Movie movie;
	private Casting cast;
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Casting getCast() {
		return cast;
	}
	public void setCast(Casting cast) {
		this.cast = cast;
	}
	
}
