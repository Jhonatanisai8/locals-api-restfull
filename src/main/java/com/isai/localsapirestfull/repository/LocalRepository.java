package com.isai.localsapirestfull.repository;

import com.isai.localsapirestfull.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository
        extends JpaRepository<Local, Long> {

}
