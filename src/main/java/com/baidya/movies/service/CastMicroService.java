package com.baidya.movies.service;


import com.baidya.movies.pojo.Casting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FRONT-WALL")
public interface CastMicroService {

    @GetMapping("/cast/{id}")
    public Casting find(@PathVariable long id);

    @GetMapping("/cast/test")
    public String test();
}
