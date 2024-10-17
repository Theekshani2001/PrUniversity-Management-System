package com.thariindi.tech_vista.controller;

import com.thariindi.tech_vista.model.Society;
import com.thariindi.tech_vista.service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/society")
public class SocietyController {
    private final SocietyService service;
    @Autowired
    public SocietyController(SocietyService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Society>> getAllSocieties(){
        List<Society> list=service.findAllSocieties();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Society> getSocietyById(@PathVariable("id") String id){
        Society society=service.findSociety(id);
        return new ResponseEntity<>(society,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Society> addSociety(@RequestBody Society society){
        Society newSociety=service.addSociety(society);
        return new ResponseEntity<>(newSociety,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Society> updateSociety(@RequestBody Society society){
        Society updateSociety=service.updateSociety(society);
        return new ResponseEntity<>(updateSociety,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSociety(@PathVariable("id") String id){
        service.deleteSociety(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
