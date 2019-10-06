package com.github.thiagolocatelli.load.service;

import com.github.thiagolocatelli.load.client.CartServiceClient;
import com.github.thiagolocatelli.load.client.MovieServiceClient;
import com.github.thiagolocatelli.load.client.RatingServiceClient;
import com.github.thiagolocatelli.load.client.UserServiceClient;
import com.github.thiagolocatelli.load.client.domain.Movie;
import com.github.thiagolocatelli.load.client.domain.User;
import com.github.thiagolocatelli.load.util.DataLoaderUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class LoadService {

    private static final Logger logger = LoggerFactory.getLogger(LoadService.class);

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private CartServiceClient cartServiceClient;

    @Autowired
    private RatingServiceClient ratingServiceClient;

    @Autowired
    private ResourceLoader resourceLoader;

    private List<Movie> localMovies = new ArrayList<>();
    private List<User> localUsers = new ArrayList<>();

    boolean hasBeenPrimed = false;

    @Async
    public void start() {
        logger.info("Load Test started");

        if(!hasBeenPrimed) {
            CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> createMovies());
            CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> createUsers());

            while(!future1.isDone() && !future2.isDone()) {
                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            logger.info("Micro services priming complete");
            hasBeenPrimed = true;
        }
        else {
            logger.info("Micro services have already been primed");
        }

    }

    private void createUsers() {
        Random random = new Random();
        List<String> firstNames = DataLoaderUtility.firstNames(resourceLoader);
        List<String> lastNames = DataLoaderUtility.lastNames(resourceLoader);

        for(int total = 0; total < 3000; total++) {
            String firstName = firstNames.get(random.nextInt(firstNames.size()-1));
            String lastName = lastNames.get(random.nextInt(lastNames.size()-1));

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUserName(firstName.toLowerCase() + "." + lastName.toLowerCase());

            User createdUser = userServiceClient.saveUser(user);
            localUsers.add(createdUser);
            logger.info("Creating user {} {}, with id", firstName, lastName, createdUser.getId());

            try {
                Thread.sleep(10);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createMovies() {
        List<DataLoaderUtility.DemoMovie> movies = DataLoaderUtility.movies(resourceLoader);

        for(DataLoaderUtility.DemoMovie demoMovie : movies) {
            logger.info("Creating movie {}, released on {}", demoMovie.getMovieName(), demoMovie.getReleaseDate());

            Movie movie = new Movie();
            movie.setName(demoMovie.getMovieName());
            movie.setReleaseYear(extractYear(demoMovie.getReleaseDate()));
            Movie createdMovie = movieServiceClient.saveMovie(movie);
            localMovies.add(createdMovie);
            logger.info("Creating movie {}, released on {}, with id {}",
                    createdMovie.getName(), createdMovie.getReleaseYear(), createdMovie.getId());

            try {
                Thread.sleep(10);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Integer extractYear(String releaseDate) {
        return Integer.parseInt(releaseDate.substring(releaseDate.lastIndexOf("/") + 1, releaseDate.length()));
    }

}
