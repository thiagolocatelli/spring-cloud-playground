package com.github.thiagolocatelli.load.client;

import com.github.thiagolocatelli.load.client.domain.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("movie-service")
public interface MovieServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1//movie/{movieId}", consumes = "application/json")
    Movie fetchMovie(@PathVariable("movieId") Long movieId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/movie", consumes = "application/json")
    Movie saveMovie(Movie movie);

}
