package com.isai.localsapirestfull.controller;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.service.LocalService;
import com.isai.localsapirestfull.service.LocalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocalController.class)
class LocalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock del servicio
    @MockitoBean
    private LocalServiceImpl localService;

    private Local local;

    @BeforeEach
    void setUp() {
        local = Local.builder()
                .id(1L)
                .name("Sanchez Technology")
                .floor("Floor 4")
                .code("ST4-3SS")
                .build();
    }

    @Test
    public void saveLocal() throws Exception {
        Local postLocal = Local.builder()
                .name("Sanchez Technology")
                .floor("Floor 4")
                .code("ST4-3SS")
                .build();

        Mockito.when(localService.saveLocal(Mockito.any(Local.class)))
                .thenReturn(local);

        mockMvc.perform(post("/saveLocal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Sanchez Technology\",\n" +
                                "    \"floor\": \"Floor 4\",\n" +
                                "    \"code\": \"ST4-3SS\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }
}
