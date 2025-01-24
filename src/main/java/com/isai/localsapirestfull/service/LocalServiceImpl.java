package com.isai.localsapirestfull.service;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalServiceImpl
        implements LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }
}
