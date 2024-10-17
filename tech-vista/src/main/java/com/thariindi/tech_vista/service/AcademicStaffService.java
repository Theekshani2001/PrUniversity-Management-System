package com.thariindi.tech_vista.service;

import com.thariindi.tech_vista.exception.AcademicStaffNotFoundException;
import com.thariindi.tech_vista.exception.AdminNotFoundException;
import com.thariindi.tech_vista.exception.StudentAcademicProfileNotFoundException;
import com.thariindi.tech_vista.model.AcademicStaff;
import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.model.StudentAcademicProfile;
import com.thariindi.tech_vista.repository.AcademicStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicStaffService {
    private final AcademicStaffRepository repository;
    @Autowired
    public AcademicStaffService(AcademicStaffRepository repository) {
        this.repository = repository;
    }

    public AcademicStaff addAcademicStaff(AcademicStaff staff){
        String lastAcademicStaffId = repository.findLastAcademicStaffId();
        String newAcademicStaffId = generateNextId(lastAcademicStaffId);
        staff.setAcademicStaffId(newAcademicStaffId);
        return repository.save(staff);
    }

    private String generateNextId(String lastAcademicStaffId) {
        if (lastAcademicStaffId == null) {
            return "AS-0001";
        }
        int idNumber = Integer.parseInt(lastAcademicStaffId.substring(3)) + 1;
        return String.format("AS-%04d", idNumber);
    }

    public List<AcademicStaff> findAllAcademicStaffs(){
        return repository.findAll();
    }

    public AcademicStaff updateAcademicStaff(AcademicStaff staff){
        return repository.save(staff);
    }

    public AcademicStaff findAcademicStaff(String id){
        return repository.findAcademicStaffByAcademicStaffId(id).
                orElseThrow(()-> new AcademicStaffNotFoundException("Academic Staff by Id : "+id+" is not found"));
    }

    public void deleteAcademicStaff(String id){
        repository.deleteById(id);
    }


    public AcademicStaff loginAcademicStaff(String name, String academicEmail){
        return repository.findAcademicStaffByNameAndAcademicEmail(name,academicEmail).orElseThrow(() -> new AcademicStaffNotFoundException("Academic Staff by name "+name+" and email "+academicEmail+" was not found"));
    }

    public AcademicStaff fetchAcademicStaffByAcademicEmail(String academicEmail){
        return repository.findAcademicStaffByAcademicEmail(academicEmail);
    }

}
