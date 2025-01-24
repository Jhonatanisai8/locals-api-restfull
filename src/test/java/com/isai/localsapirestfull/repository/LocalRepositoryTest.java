package com.isai.localsapirestfull.repository;

import com.isai.localsapirestfull.entity.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocalRepositoryTest {
    @Autowired
    LocalRepository localRepository;
    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Local local =
                Local.builder()
                        .name("Ojeda Innovations")
                        .floor("Floor 5")
                        .code("OI2-W43")
                        .build();
        entityManager.persist(local);
    }

    @Test
    public void findByNameIgnoreCaseFound() {
        Optional<Local> local = localRepository
                .findByNameIgnoreCase("Ojeda Innovations");
        assertEquals(local.get().getName(), "Ojeda Innovations");
        System.out.println("local.get() = " + local.get());
    }

    @Test
    public void findByNameIgnoreCaseNotFound() {
        Optional<Local> local = localRepository
                .findByNameIgnoreCase("HyD Innovations");
        assertEquals(local, Optional.empty());
    }
}