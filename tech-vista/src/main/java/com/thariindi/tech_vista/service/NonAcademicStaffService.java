package com.thariindi.tech_vista.service;

import com.thariindi.tech_vista.exception.AcademicStaffNotFoundException;
import com.thariindi.tech_vista.exception.AdminNotFoundException;
import com.thariindi.tech_vista.exception.NonAcademicStaffNotFoundException;
import com.thariindi.tech_vista.model.AcademicStaff;
import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.model.NonAcademicStaff;
import com.thariindi.tech_vista.repository.NonAcademicStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonAcademicStaffService {
    private final NonAcademicStaffRepository repository;
    @Autowired
    public NonAcademicStaffService(NonAcademicStaffRepository repository) {
        this.repository = repository;
    }

    public NonAcademicStaff addNonAcademicStaff(NonAcademicStaff staff){
        String lastNonAcademicStaffId = repository.findLastNonAcademicStaffId();
        String newNonAcademicStaffId = generateNextId(lastNonAcademicStaffId);
        staff.setNonAcademicStaffId(newNonAcademicStaffId);
        return repository.save(staff);
    }

    private String generateNextId(String lastNonAcademicStaffId) {
        if (lastNonAcademicStaffId == null) {
            return "NAS-0001";
        }
        int idNumber = Integer.parseInt(lastNonAcademicStaffId.substring(4)) + 1;
        return String.format("NAS-%04d", idNumber);
    }

    public List<NonAcademicStaff> findAllNonAcademicStaffs(){
        return repository.findAll();
    }

    public NonAcademicStaff updateNonAcademicStaff(NonAcademicStaff staff){
        return repository.save(staff);
    }

    public NonAcademicStaff findNonAcademicStaff(String id){
        return repository.findNonAcademicStaffByNonAcademicStaffId(id).
                orElseThrow(()-> new NonAcademicStaffNotFoundException("NonAcademic Staff by Id : "+id+" is not found"));
    }

    public void deleteNonAcademicStaff(String id){
        repository.deleteById(id);
    }

    public NonAcademicStaff loginNonAcademicStaff(String name, String nonAcademicStaffMail){
        return repository.findNonAcademicStaffByNameAndNonAcademicStaffMail(name,nonAcademicStaffMail).orElseThrow(() -> new NonAcademicStaffNotFoundException("Non Academic Staff by name "+name+" and email "+nonAcademicStaffMail+" was not found"));
    }

}
