package com.example.demo;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NutzerService {

    @Autowired
    WasserRepository wasserRepo;
    @Autowired
    NutzerRepository nutzerRepo;

    public Benutzer save(Benutzer benutzer) {
        return nutzerRepo.save(benutzer);
    }

    public Wasser saveWasser(Wasser wasser){return  wasserRepo.save(wasser);}

    public Benutzer get(Long id) {
        return nutzerRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Wasser> getAll(String email) {
       Iterable<Wasser> iterator = wasserRepo.findAll();
       List<Wasser> wassers = new ArrayList<>();
       for(Wasser wasser : iterator){
           if(wasser.getOwner() != null && wasser.getOwner().equals(email)){
               wassers.add(wasser);
           }
       }
       return wassers;
    }

}
