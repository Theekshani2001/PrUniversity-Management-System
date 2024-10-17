package com.thariindi.tech_vista.controller;

import com.thariindi.tech_vista.model.AcademicStaff;
import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.service.AcademicStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academicStaff")
public class AcademicStaffController {
    private final AcademicStaffService service;
    @Autowired
    public AcademicStaffController(AcademicStaffService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AcademicStaff>> getAllAcademicStaffs(){
        List<AcademicStaff> staffs=service.findAllAcademicStaffs();
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<AcademicStaff> getAcademicStaffById(@PathVariable("id") String id){
        AcademicStaff staff=service.findAcademicStaff(id);
        return new ResponseEntity<>(staff,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AcademicStaff> addAcademicStaff(@RequestBody AcademicStaff staff){
        AcademicStaff newAcademicStaff=service.addAcademicStaff(staff);
        return new ResponseEntity<>(newAcademicStaff,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AcademicStaff> updateAcademicStaff(@RequestBody AcademicStaff staff){
        AcademicStaff updateAcademicStaff=service.updateAcademicStaff(staff);
        return new ResponseEntity<>(updateAcademicStaff,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAcademicStaff(@PathVariable("id") String id){
        service.deleteAcademicStaff(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login/{name}/{email}")

    public ResponseEntity<AcademicStaff> login(@PathVariable("name") String name, @PathVariable("email") String email){
        AcademicStaff staff=service.loginAcademicStaff(name,email);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
