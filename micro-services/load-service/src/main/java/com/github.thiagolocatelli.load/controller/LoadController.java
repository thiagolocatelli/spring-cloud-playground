package com.github.thiagolocatelli.load.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoadController {

    @GetMapping("/load/start")
    public ResponseEntity start() {
        return ResponseEntity.ok().build();
    }
}
