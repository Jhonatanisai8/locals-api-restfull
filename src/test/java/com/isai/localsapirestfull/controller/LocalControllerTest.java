package com.isai.localsapirestfull.controller;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.service.LocalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

        Mockito.when(localService.saveLocal(postLocal))
                .thenReturn(local);

        mockMvc.perform(post("/saveLocal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "Sanchez Technology",
                                    "floor": "Floor 4",
                                    "code": "ST4-3SS"
                                }"""))
                .andExpect(status().isOk());
    }

    @Test
    public void findLocalById() throws Exception {
        Mockito.when(localService.findLocalById(1L))
                .thenReturn(local);
        mockMvc.perform(get("/findLocalById/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                        .value(local.getName()));
    }
}
