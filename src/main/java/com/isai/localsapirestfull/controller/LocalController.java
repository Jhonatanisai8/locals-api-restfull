package com.isai.localsapirestfull.controller;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.service.LocalServiceImpl;
import lombok.Getter;
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

    @GetMapping("/findLocalByName/{name}")
    public Optional<Local> findLocalByName(@PathVariable String name) {
        return localServiceImpl.findLocalByName(name);
    }

    @PostMapping("/saveLocal")
    public Local saveLocal(@RequestBody Local local) {
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
