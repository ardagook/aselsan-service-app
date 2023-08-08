package com.ardagok.busstopapp.controller;

import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.service.BusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BusController.class)
class BusControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BusService busService;

    @Test
     void testGetBusByIdExistingId() throws Exception {
        long busId = (int) 1L;
        BusEntity mockBus = new BusEntity();
        mockBus.setId((int) busId);

        when(busService.getBusById(busId)).thenReturn(Optional.of(mockBus));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/buses/{id}", busId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(busId));
    }

    @Test
     void testGetBusByIdNonExistingId() throws Exception {
        long nonExistingBusId = (int) 999L;
        when(busService.getBusById(nonExistingBusId)).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/buses/{id}", nonExistingBusId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}