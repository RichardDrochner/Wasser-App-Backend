package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NutzerTest {

    @Test
    void testToString() {
        int amount = 99;

        Benutzer wasser = new Benutzer("Richard", "Drochner", "richard@mail.com");
        wasser.setId(42L);

        String expected = "Benutzer{id=42, name=Richard, email=richard@mail.com}";

        String actual = wasser.toString();

        assertEquals(expected, actual);
    }
}


