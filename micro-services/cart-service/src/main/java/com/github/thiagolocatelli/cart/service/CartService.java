package com.github.thiagolocatelli.cart.service;

import com.github.thiagolocatelli.cart.client.MovieServiceClient;
import com.github.thiagolocatelli.cart.client.UserServiceClient;
import com.github.thiagolocatelli.cart.domain.CartItem;
import com.github.thiagolocatelli.cart.repository.CartItemRepository;
import com.netflix.client.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    public CartItem save(CartItem cartItem) {
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
