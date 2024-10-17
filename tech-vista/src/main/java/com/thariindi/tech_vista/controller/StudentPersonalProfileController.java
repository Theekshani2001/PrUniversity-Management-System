package com.thariindi.tech_vista.controller;


import com.thariindi.tech_vista.model.StudentPersonalProfile;
import com.thariindi.tech_vista.service.StudentPersonalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentPersonalProfile")
public class StudentPersonalProfileController {
    private final StudentPersonalProfileService service;
    @Autowired
    public StudentPersonalProfileController(StudentPersonalProfileService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentPersonalProfile>> getAllStudentPersonalProfiles(){
        List<StudentPersonalProfile> list=service.findAllStudentPersonalProfiles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<StudentPersonalProfile> getStudentPersonalProfileById(@PathVariable("id") String id){
        StudentPersonalProfile profile=service.findStudentPersonalProfile(id);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentPersonalProfile> addStudentPersonalProfile(@RequestBody StudentPersonalProfile profile){
        StudentPersonalProfile newProfile=service.addStudentPersonalProfile(profile);
        return new ResponseEntity<>(newProfile,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentPersonalProfile> updateStudentPersonalProfile(@RequestBody StudentPersonalProfile profile){
        StudentPersonalProfile updateProfile=service.updateStudentPersonalProfile(profile);
        return new ResponseEntity<>(updateProfile,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentPersonalProfile(@PathVariable("id") String id){
        service.deleteStudentPersonalProfile(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
