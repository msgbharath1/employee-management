package com.employee.management.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/employees")).andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/employees/1")).andExpect(status().isOk());
    }

    @Test
    void duplicate() throws Exception {
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content("{\"id\":1,\"name\":\"Bharath Sundaresan\",\"email\":\"bharath_sundaresan@gmail.com\"}")).andExpect(status().isConflict());
    }
}
