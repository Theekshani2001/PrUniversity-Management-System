package com.thariindi.tech_vista.controller;
import com.thariindi.tech_vista.model.NonAcademicStaff;
import com.thariindi.tech_vista.service.NonAcademicStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonAcademicStaff")
public class NonAcademicStaffController {
    private final NonAcademicStaffService service;
    @Autowired
    public NonAcademicStaffController(NonAcademicStaffService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<NonAcademicStaff>> getAllNonAcademicStaffs(){
        List<NonAcademicStaff> staffs=service.findAllNonAcademicStaffs();
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<NonAcademicStaff> getNonAcademicStaffById(@PathVariable("id") String id){
        NonAcademicStaff staff=service.findNonAcademicStaff(id);
        return new ResponseEntity<>(staff,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<NonAcademicStaff> addNonAcademicStaff(@RequestBody NonAcademicStaff staff){
        NonAcademicStaff newNonAcademicStaff=service.addNonAcademicStaff(staff);
        return new ResponseEntity<>(newNonAcademicStaff,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<NonAcademicStaff> updateNonAcademicStaff(@RequestBody NonAcademicStaff staff){
        NonAcademicStaff updateNonAcademicStaff=service.updateNonAcademicStaff(staff);
        return new ResponseEntity<>(updateNonAcademicStaff,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNonAcademicStaff(@PathVariable("id") String id){
        service.deleteNonAcademicStaff(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login/{name}/{nonAcademicStaffMail}")

    public ResponseEntity<NonAcademicStaff> login(@PathVariable("name") String name, @PathVariable("nonAcademicStaffMail") String nonAcademicStaffMail){
        NonAcademicStaff staff=service.loginNonAcademicStaff(name,nonAcademicStaffMail);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
