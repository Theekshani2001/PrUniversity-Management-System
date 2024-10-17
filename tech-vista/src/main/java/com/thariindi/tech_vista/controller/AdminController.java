package com.thariindi.tech_vista.controller;

import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService service;
    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) throws Exception {
        String tempEmail=admin.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)){
            Admin adminObj= service.fetchAdminByAdminEmail(tempEmail);
            if (adminObj != null){
                throw new Exception("Admin with "+tempEmail+" is already exists");
            }
        }


        Admin newAdmin=null;
        newAdmin=service.saveAdmin(admin);
        return newAdmin;
    }

    @GetMapping("/login/{email}/{password}")

    public ResponseEntity<Admin> login(@PathVariable("email") String email, @PathVariable("password") String password){
        Admin admin=service.loginAdmin(email, password);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }


}
