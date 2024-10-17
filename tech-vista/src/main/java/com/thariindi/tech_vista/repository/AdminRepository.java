package com.thariindi.tech_vista.repository;

import com.thariindi.tech_vista.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findAdminById(Long id);

    public Admin findAdminByEmail(String email);

    Optional<Admin> findAdminByEmailAndPassword(String email,String password);
}
