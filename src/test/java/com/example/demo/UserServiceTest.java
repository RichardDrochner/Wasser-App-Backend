package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    @Disabled
    @DisplayName("should find User by Id")
    void TestFindById(){
        var p1 = new Wasser(15);
        var p2 = new Wasser(2);
        doReturn(Optional.of(p1)).when(repository).findById(42L);
        doReturn(Optional.of(p2)).when(repository).findById(43L);

        Wasser actual = service.get(42L);

        assertEquals(actual.getAmount(), 15);


    }
}
