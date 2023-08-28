package com.baidya.movies.repository;

import com.baidya.movies.pojo.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class LoadTestData {
    private final MovieRepository movieRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(LoadTestData.class);
    public LoadTestData(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Bean
    public CommandLineRunner loadDummyData(){
        return args -> {
            LOGGER.info("Adding movie: ", String.format(" %s \n", movieRepository.save(new Movie(1L, "Spiderman 3", Calendar.getInstance().getTime(), "200 million", 1L))));
            LOGGER.info("Adding movie: ", String.format(" %s \n", movieRepository.save(new Movie(2L, "Batman & Joker", Calendar.getInstance().getTime(), "220 million", 2L))));
        };
    }

}
