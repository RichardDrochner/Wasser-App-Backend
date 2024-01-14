package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class WasserServiceTest {
    @Autowired
    private NutzerService service;

    @MockBean
    private WasserRepository repository;

    @Test
    @DisplayName("should find a wasser by its Id")
    public void wasserServiceTest(){
        LocalDate fixedDate = LocalDate.of(2024, 1, 1);
        var p1 = new Wasser(fixedDate, "richard@mail.com", 3.0, 1.5);
        var p2 = new Wasser(fixedDate, "alim@mail.com", 2.5, 2.0);

        p1.setId(42L);
        p2.setId(43L);
        doReturn(Optional.of(p1)).when(repository).findById(42L);
        doReturn(Optional.of(p2)).when(repository).findById(43L);

        Wasser actual = service.getWasser(42L);

        assertEquals(actual.getOwner(), "richard@mail.com");

    }
}
