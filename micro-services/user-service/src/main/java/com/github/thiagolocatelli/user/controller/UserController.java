package com.github.thiagolocatelli.user.controller;

import com.github.thiagolocatelli.user.domain.User;
import com.github.thiagolocatelli.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok(userService.all());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> user(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.user(userId));
    }

}
