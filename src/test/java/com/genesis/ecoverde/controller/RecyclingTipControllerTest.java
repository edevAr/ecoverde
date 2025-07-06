package com.genesis.ecoverde.controller;

import com.genesis.ecoverde.entity.RecyclingTip;
import com.genesis.ecoverde.service.RecyclingTipService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecyclingTipController.class)
public class RecyclingTipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecyclingTipService service;

    @Test
    void shouldReturnAllTips() throws Exception {
        when(service.getAll()).thenReturn(List.of(new RecyclingTip("Usa menos plástico")));

        mockMvc.perform(get("/api/recycling-tips"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tip").value("Usa menos plástico"));
    }

    @Test
    void shouldReturnTipById() throws Exception {
        when(service.getById(1L)).thenReturn(Optional.of(new RecyclingTip("Separa tu basura")));

        mockMvc.perform(get("/api/recycling-tips/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tip").value("Separa tu basura"));
    }
}
