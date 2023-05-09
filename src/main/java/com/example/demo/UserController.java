package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/User")
    public Wasser createUser(@RequestBody Wasser wasser) {
        return service.save(wasser);
    }

    @GetMapping("/users/{id}")
    public Wasser getUser(@PathVariable String id) {
        logger.info("GET request on route Wasser with {}", id);
        Long UserId = Long.parseLong(id);
        return service.get(UserId);
    }

    @GetMapping("/users")
    public List<Wasser> getAllUsers() {
        return service.getAll();
    }
}
