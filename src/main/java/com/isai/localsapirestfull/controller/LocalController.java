package com.isai.localsapirestfull.controller;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.service.LocalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalController {
    @Autowired
    private LocalServiceImpl localServiceImpl;

    @GetMapping("/findAllLocals")
    public List<Local> findAllLocals() {
        return localServiceImpl.findAllLocals();
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
    public void deleteLocal(@PathVariable Long localID) {
        localServiceImpl.deleteLocal(localID);
    }
}
