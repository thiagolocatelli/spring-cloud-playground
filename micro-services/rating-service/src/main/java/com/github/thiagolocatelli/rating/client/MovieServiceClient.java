package com.github.thiagolocatelli.rating.client;

import com.github.thiagolocatelli.rating.client.domain.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("movie-service")
public interface MovieServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1//movie/{movieId}", consumes = "application/json")
    ResponseEntity<Movie> fetchMovie(@PathVariable("movieId") Long movieId);

}