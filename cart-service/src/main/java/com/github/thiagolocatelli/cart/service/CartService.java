package com.github.thiagolocatelli.cart.service;

import com.github.thiagolocatelli.cart.domain.CartItem;
import com.github.thiagolocatelli.cart.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

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
