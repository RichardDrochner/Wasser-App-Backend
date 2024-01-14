package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NutzerController.class)
public class WasserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NutzerService service;

    @Test
    public void getRoute() throws Exception{
        LocalDate fixedDate = LocalDate.of(2024, 1, 1);
        var p1 = new Wasser(fixedDate, "richard@mail.com", 3.0, 2.3);
        p1.setId(42L);
        when(service.getWasser(42L)).thenReturn(p1);

        String expected = "{\"id\":42,\"name\":null,\"email\":null,\"owner\":\"richard@mail.com\",\"date\":\"2024-01-01\",\"tagesziel\":3.0,\"getrunken\":2.3}";

        this.mockMvc.perform(get("/wassers/42"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

}

