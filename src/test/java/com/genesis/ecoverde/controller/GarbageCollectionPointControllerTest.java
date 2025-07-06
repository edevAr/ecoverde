package com.genesis.ecoverde.controller;

import com.genesis.ecoverde.entity.GarbageCollectionPoint;
import com.genesis.ecoverde.service.GarbageCollectionPointService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GarbageCollectionPointController.class)
public class GarbageCollectionPointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GarbageCollectionPointService service;

    @Test
    void shouldReturnListOfPoints() throws Exception {
        when(service.getAll()).thenReturn(List.of(new GarbageCollectionPoint("Zona 1")));

        mockMvc.perform(get("/api/garbage-points"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].address").value("Zona 1"));
    }

    @Test
    void shouldReturnPointById() throws Exception {
        when(service.getById(1L)).thenReturn(Optional.of(new GarbageCollectionPoint("Zona 2")));

        mockMvc.perform(get("/api/garbage-points/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value("Zona 2"));
    }
}
