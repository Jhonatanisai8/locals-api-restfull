package com.isai.localsapirestfull.controller;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.service.LocalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocalController {
    @Autowired
    private LocalServiceImpl localServiceImpl;

    @GetMapping("/findAllLocals")
    public List<Local> findAllLocals() {
        return localServiceImpl.findAllLocals();
    }
}
