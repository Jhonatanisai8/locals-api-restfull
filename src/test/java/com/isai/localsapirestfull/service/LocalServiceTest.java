package com.isai.localsapirestfull.service;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalServiceTest {

    @Autowired
    private LocalService localService;
    @MockitoBean
    private LocalRepository localRepository;

    @BeforeEach
    void setUp() {
        Local local =
                Local.builder()
                        .id(1L)
                        .name("Innovations")
                        .floor("Floor 5")
                        .code("OI2-W43")
                        .build();
        Mockito.when(localRepository
                        .findByNameIgnoreCase("Innovations"))
                .thenReturn(Optional.of(local));
    }

    @Test
    @DisplayName("Prueba de obtención de informacion de un local enviando un nombre valido ")
    public void findByNameIgnoreCaseShouldFound() {
        String localName = "Innovations";
        Local local = localService
                .findByNameIgnoreCase(localName)
                .get();
        assertEquals(localName, local.getName());
        System.out.println("local = " + local);
    }
}