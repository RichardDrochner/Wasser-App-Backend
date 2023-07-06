package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService service;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/User")
    @CrossOrigin
    public Long createUser(@RequestBody Wasser wasser) {
        service.save(wasser);
        Long id = wasser.getId();
        return id;
    }

    @GetMapping("/users/{id}")
    public Wasser getUser(@PathVariable String id, @RequestParam("variable") int getrunken) {
        logger.info("GET request on route Wasser with {}", id);
        Long UserId = Long.parseLong(id);
        Wasser user = service.get(UserId);
        user.setGetrunken(getrunken);
        return user;
    }

    @GetMapping("/users")
    @CrossOrigin
    public List<Wasser> getAllUsers() {
        return service.getAll();
    }
}
