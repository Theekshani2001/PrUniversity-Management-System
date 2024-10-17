package com.thariindi.tech_vista.controller;
import com.thariindi.tech_vista.model.SocietyMember;
import com.thariindi.tech_vista.service.SocietyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/societyMember")
public class SocietyMemberController {
    private final SocietyMemberService service;
    @Autowired
    public SocietyMemberController(SocietyMemberService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<SocietyMember>> getAllSocietyMembers(){
        List<SocietyMember> list=service.findAllSocietyMembers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SocietyMember> getSocietyMemberById(@PathVariable("id") String id){
        SocietyMember societyMember=service.findSocietyMember(id);
        return new ResponseEntity<>(societyMember,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SocietyMember> addSociety(@RequestBody SocietyMember societyMember){
        SocietyMember newSocietyMember=service.addSocietyMember(societyMember);
        return new ResponseEntity<>(newSocietyMember,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SocietyMember> updateSocietyMember(@RequestBody SocietyMember societyMember){
        SocietyMember updateSocietyMember=service.updateSocietyMember(societyMember);
        return new ResponseEntity<>(updateSocietyMember,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSocietyMember(@PathVariable("id") String id){
        service.deleteSocietyMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
