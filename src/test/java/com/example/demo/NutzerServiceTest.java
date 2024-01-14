package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class NutzerServiceTest {
    @Autowired
    private NutzerService service;

    @MockBean
    private NutzerRepository repository;

    @Test
    @Disabled
    @DisplayName("should find User by Id")
    void TestFindById(){
        var p1 = new Benutzer("Richard", "richard@mail.com");
        var p2 = new Benutzer("Alim", "Alim@mail.com");
        p1.setId(42L);
        p2.setId(43L);
        doReturn(Optional.of(p1)).when(repository).findById(42L);
        doReturn(Optional.of(p2)).when(repository).findById(43L);

        Benutzer actual = service.get(42L);

        assertEquals(actual.getEmail(), "richard@mail.com");


    }
}
