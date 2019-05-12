package com.github.thiagolocatelli.cart.service;

import com.github.thiagolocatelli.cart.client.MovieServiceClient;
import com.github.thiagolocatelli.cart.client.UserServiceClient;
import com.github.thiagolocatelli.cart.domain.CartItem;
import com.github.thiagolocatelli.cart.repository.CartItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    public CartItem save(CartItem cartItem) {

        if(movieServiceClient.fetchMovie(cartItem.getMovieId()).getStatusCode() != HttpStatus.OK) {
            logger.warn("Unable to create cart entry, movieId {} is invalid");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Movie");
        }

        if(userServiceClient.fetchUser(cartItem.getUserId()).getStatusCode() != HttpStatus.OK) {
            logger.warn("Unable to create cart entry, userId {} is invalid");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Movie");
        }

        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> userCart(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    public List<CartItem> remove(Long userId, Long movieId) {
        cartItemRepository.deleteByUserIdAndMovieId(userId, movieId);
        return cartItemRepository.findByUserId(userId);
    }

}
