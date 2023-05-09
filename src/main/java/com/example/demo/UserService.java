package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public Wasser save(Wasser wasser) {
        return repo.save(wasser);
    }

    public Wasser get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Wasser> getAll() {
        Iterable<Wasser> iterator = repo.findAll();
        List<Wasser> wassers = new ArrayList<Wasser>();
        for (Wasser wasser : iterator)
            wassers.add(wasser);
        return wassers;
    }

}
