package com.example.creteriatraining.controller;

import com.example.creteriatraining.service.DataInjector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    private DataInjector dataInjector;

    public DataController(DataInjector dataInjector) {
        this.dataInjector = dataInjector;
    }

    @GetMapping("/inject")
    public ResponseEntity<String> injectData(){
        dataInjector.injectData();
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }


}
