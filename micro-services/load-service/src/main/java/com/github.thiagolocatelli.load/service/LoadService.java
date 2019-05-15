package com.github.thiagolocatelli.load.service;

import com.github.thiagolocatelli.load.client.CartServiceClient;
import com.github.thiagolocatelli.load.client.MovieServiceClient;
import com.github.thiagolocatelli.load.client.RatingServiceClient;
import com.github.thiagolocatelli.load.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadService {

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private CartServiceClient cartServiceClient;

    @Autowired
    private RatingServiceClient ratingServiceClient;

}
