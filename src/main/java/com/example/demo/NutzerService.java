package com.example.demo;

import java.time.LocalDate;
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
        Iterable<Benutzer> iterator = nutzerRepo.findAll();
        for(Benutzer nutzer : iterator){
            if(nutzer.getName() != null && nutzer.getEmail() != null) {
                if (nutzer.getEmail().equals(benutzer.getEmail())) {
                    nutzer.setName(benutzer.getName());
                    nutzer.setEmail(benutzer.getEmail());
                    return nutzerRepo.save(nutzer);
                }
            }
        }
        return nutzerRepo.save(benutzer);
    }

    public Wasser saveWasser(Wasser wasser){
        Iterable<Wasser> iterator = wasserRepo.findAll();
        LocalDate date = LocalDate.now();
        for(Wasser wassers : iterator){
            if(wassers.getOwner() != null) {
                if (wassers.getOwner().equals(wasser.getOwner()) && wasser.getDate().equals(date)) {
                    wassers.setTagesziel(wasser.getTagesziel());
                    wassers.setGetrunken(wasser.getGetrunken());
                    return wasserRepo.save(wassers);
                }
            }
        }
        return  wasserRepo.save(wasser);
    }

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

    public List<Wasser> getAllWithoutOwner(){
        Iterable<Wasser> iterator = wasserRepo.findAll();
        List<Wasser> wassers = new ArrayList<>();
        for(Wasser wasser : iterator){
            if(wasser.getOwner() == null) wassers.add(wasser);
        }
        return wassers;
    }
}
