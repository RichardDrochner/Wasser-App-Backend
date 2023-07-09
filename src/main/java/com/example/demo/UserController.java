package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    UserService service;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/User")
    @CrossOrigin
    public Long createUser(@RequestBody Wasser wasser) {
        service.save(wasser);
        System.out.println(wasser.getId());
        return wasser.getId();
    }

    @GetMapping("/users/{id}")
    public int getUser(@PathVariable String id, @RequestParam("variable") int getrunken) {
        logger.info("GET request on route Wasser with {}", id);
        Long UserId = Long.parseLong(id);
        Wasser user = service.get(UserId);
        user.setGetrunken(getrunken);
        int trinken = user.getGetrunken();
        return trinken;
    }

    @GetMapping("/users")
    @CrossOrigin
    public List<Wasser> getAllUsers() {
        return service.getAll();
    }
}
