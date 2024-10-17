package com.thariindi.tech_vista.service;

import com.thariindi.tech_vista.exception.AdminNotFoundException;
import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository repository;
    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public Admin loginAdmin(String email, String password){
        return repository.findAdminByEmailAndPassword(email,password).orElseThrow(() -> new AdminNotFoundException("Admin by email "+email+" and password "+password+" was not found"));
    }


    public Admin saveAdmin(Admin admin){
        return repository.save(admin);
    }

    public Admin fetchAdminByAdminEmail(String email){
        return repository.findAdminByEmail(email);
    }
}
