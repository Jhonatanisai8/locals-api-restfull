package com.isai.localsapirestfull.controller;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.error.LocalNotFoundException;
import com.isai.localsapirestfull.service.LocalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {
    @Autowired
    private LocalServiceImpl localServiceImpl;

    @GetMapping("/findAllLocals")
    public List<Local> findAllLocals() {
        return localServiceImpl.findAllLocals();
    }

    @GetMapping("/findLocalByNameJPQL/{name}")
    Optional<Local> findLocalByNameJPQL(@PathVariable String name) {
        return localServiceImpl.findLocalByNameJPQL(name);
    }

    @GetMapping("/findByName/{name}")
    public Optional<Local> findByName(@PathVariable String name) {
        return localServiceImpl.findByName(name);
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    public Optional<Local> findByNameIgnoreCase(@PathVariable String name) {
        return localServiceImpl.findByNameIgnoreCase(name);
    }

    @GetMapping("/findLocalById/{localID}")
    public Local findLocalById(@PathVariable Long localID) throws LocalNotFoundException {
        return localServiceImpl.findLocalById(localID);
    }

    @PostMapping("/saveLocal")
    public Local saveLocal(@Valid @RequestBody Local local) {
        return localServiceImpl.saveLocal(local);
    }

    @PutMapping("/updateLocal/{localID}")
    public Local updateLocal(@PathVariable Long localID,
                             @RequestBody Local local) {
        return localServiceImpl.updateLocal(localID, local);
    }

    @DeleteMapping("/deleteLocal/{localID}")
    public String deleteLocal(@PathVariable Long localID) {
        localServiceImpl.deleteLocal(localID);
        return "Deleted Local with ID: " + localID;
    }


}
