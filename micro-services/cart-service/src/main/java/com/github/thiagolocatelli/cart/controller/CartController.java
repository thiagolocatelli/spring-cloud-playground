package com.github.thiagolocatelli.cart.controller;

import com.github.thiagolocatelli.cart.domain.CartItem;
import com.github.thiagolocatelli.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<CartItem> save(@RequestBody CartItem cartItem) {
        return ResponseEntity.ok(cartService.save(cartItem));
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<List<CartItem>> userCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.userCart(userId));
    }

    @DeleteMapping("/cart/{userId}/{movieId}")
    public ResponseEntity<List<CartItem>> remove(@PathVariable Long userId, @PathVariable Long movieId) {
        return ResponseEntity.ok(cartService.remove(userId, movieId));
    }

}
