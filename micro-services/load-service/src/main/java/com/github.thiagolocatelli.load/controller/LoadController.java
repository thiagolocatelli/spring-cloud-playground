package com.github.thiagolocatelli.load.controller;

import com.github.thiagolocatelli.load.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @GetMapping("/load/start")
    public ResponseEntity start() {
        loadService.start();
        return ResponseEntity.ok().build();
    }
}
