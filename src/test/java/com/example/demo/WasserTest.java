package com.example.demo;

import com.example.demo.Wasser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WasserTest {

    @Test
    void testToString() {
        int amount = 99;

        Wasser wasser = new Wasser(amount);
        wasser.setId(42L);

        String expected = "Wasser{id=42, amount=99, getrunken=0}";

        String actual = wasser.toString();

        assertEquals(expected, actual);
    }
}


