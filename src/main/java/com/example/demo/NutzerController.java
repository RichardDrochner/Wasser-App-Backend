package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class NutzerController {

    @Autowired
    NutzerService service;

    Logger logger = LoggerFactory.getLogger(NutzerController.class);

    @PostMapping("/User")
    @CrossOrigin
    public Long createUser(@RequestBody Benutzer benutzer) {
        service.save(benutzer);
        System.out.println(benutzer.getId());
        return benutzer.getId();
    }

    @GetMapping("/users/{id}")
    public Benutzer getBenutzer(@PathVariable String id) {
        logger.info("GET request on route Wasser with {}", id);
        Long BenutzerId = Long.parseLong(id);
        return service.get(BenutzerId);
    }

    @PostMapping("/Wasser")
    @CrossOrigin
    public Wasser createWasser(@RequestBody Wasser wasser){
        return service.saveWasser(wasser);
    }

    @GetMapping("/users")
    @CrossOrigin
    public List<Wasser> getAllForUser(@RequestParam("mail") String email) {
        return service.getAll(email);
    }
}
