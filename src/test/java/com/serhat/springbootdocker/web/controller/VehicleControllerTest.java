package com.serhat.springbootdocker.web.controller;

import com.fasterxml.jackson.databind.*;

import com.serhat.springbootdocker.service.*;
import com.serhat.springbootdocker.web.dto.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;

import java.math.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService service;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void getVehicleById() {
    }

    @Test
    void saveVehicle() throws Exception {

        VehicleDto vehicle = VehicleDto.builder()
                .modal("renault")
                .price(new BigDecimal(250000))
                .type("sedan").build();

        given(service.saveVehicle(any(VehicleDto.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/v1/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(vehicle)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.modal",
                        is(vehicle.getModal())))
                .andExpect(jsonPath("$.type",
                        is(vehicle.getType())))
                .andExpect(jsonPath("price",
                        is(250000)));

    }

    @Test
    void getAllVehicles() {
    }
}
