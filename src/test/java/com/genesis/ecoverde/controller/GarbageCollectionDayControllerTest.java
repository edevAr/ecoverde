package com.genesis.ecoverde.controller;

import com.genesis.ecoverde.entity.GarbageCollectionDay;
import com.genesis.ecoverde.service.GarbageCollectionDayService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GarbageCollectionDayController.class)
public class GarbageCollectionDayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GarbageCollectionDayService service;

    @Test
    void shouldReturnAllDays() throws Exception {
        GarbageCollectionDay day = new GarbageCollectionDay("America/La_Paz", "Zona Sur", "Monday");
        when(service.getAll()).thenReturn(List.of(day));

        mockMvc.perform(get("/api/garbage-days"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].day").value("Monday"));
    }

    @Test
    void shouldReturnDayById() throws Exception {
        GarbageCollectionDay day = new GarbageCollectionDay("UTC", "Centro", "Friday");
        when(service.getById(2L)).thenReturn(Optional.of(day));

        mockMvc.perform(get("/api/garbage-days/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.zone").value("Centro"));
    }
}
