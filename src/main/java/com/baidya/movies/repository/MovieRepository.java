package com.baidya.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baidya.movies.pojo.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
