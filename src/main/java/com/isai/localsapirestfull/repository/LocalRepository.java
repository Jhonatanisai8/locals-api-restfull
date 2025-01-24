package com.isai.localsapirestfull.repository;

import com.isai.localsapirestfull.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalRepository
        extends JpaRepository<Local, Long> {
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findLocalByNameJPQL(String name);

    Optional<Local> findByName(String name);

    Optional<Local> findByNameIgnoreCase(String name);
}
