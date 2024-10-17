package com.thariindi.tech_vista.controller;

import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.model.StudentAcademicProfile;
import com.thariindi.tech_vista.service.StudentAcademicProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentAcademicProfile")
public class StudentAcademicProfileController {
    private final StudentAcademicProfileService service;
    @Autowired
    public StudentAcademicProfileController(StudentAcademicProfileService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentAcademicProfile>> getAllStudentAcademicProfiles(){
        List<StudentAcademicProfile> list=service.findAllStudentAcademicProfiles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/find/{email}")
    public ResponseEntity<StudentAcademicProfile> getStudentAcademicProfileById(@PathVariable("email") String email){
        StudentAcademicProfile profile=service.findStudentAcademicProfile(email);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentAcademicProfile> addStudentAcademicProfile(@RequestBody StudentAcademicProfile profile) throws Exception {
        String tempEmail=profile.getAcademicMail();
        if(tempEmail != null && !"".equals(tempEmail)){
            StudentAcademicProfile obj= service.fetchStudentAcademicProfileByAcademicMail(tempEmail);
            if (obj != null){
                throw new Exception("Student with "+tempEmail+" is already exists");
            }
        }
        StudentAcademicProfile studentAcademicProfile=null;
        studentAcademicProfile=service.addStudentAcademicProfile(profile);
        return new ResponseEntity<>(studentAcademicProfile,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentAcademicProfile> updateStudentAcademicProfile(@RequestBody StudentAcademicProfile profile){
        StudentAcademicProfile updateProfile=service.updateStudentAcademicProfile(profile);
        return new ResponseEntity<>(updateProfile,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentAcademicProfile(@PathVariable("id") String id){
        service.deleteStudentAcademicProfile(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/login/{name}/{email}")

    public ResponseEntity<StudentAcademicProfile> login(@PathVariable("name") String name, @PathVariable("email") String email){
        StudentAcademicProfile profile=service.loginStudent(name, email);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
