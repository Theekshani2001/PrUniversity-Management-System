package com.thariindi.tech_vista.service;

import com.thariindi.tech_vista.exception.SocietyNotFoundException;
import com.thariindi.tech_vista.model.AcademicStaff;
import com.thariindi.tech_vista.model.Society;
import com.thariindi.tech_vista.repository.AcademicStaffRepository;
import com.thariindi.tech_vista.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyService {
    private final SocietyRepository repository;
    private AcademicStaffRepository academicStaffRepository;
    @Autowired
    public SocietyService(SocietyRepository repository) {
        this.repository = repository;
    }

    public Society addSociety(Society society){
        String lastSocietyId = repository.findLastSocietyId();
        String newSocietyId = generateNextId(lastSocietyId);
        society.setSocietyId(newSocietyId);
        return repository.save(society);
    }
    private String generateNextId(String lastSocietyId) {
        if (lastSocietyId == null) {
            return "SO-0001";
        }
        int idNumber = Integer.parseInt(lastSocietyId.substring(3)) + 1;
        return String.format("SO-%04d", idNumber);
    }

    public List<Society> findAllSocieties(){
        return repository.findAll();
    }

    public Society updateSociety(Society society){
        return repository.save(society);
    }

    public Society findSociety(String id){
        return repository.findSocietyBySocietyId(id).
                orElseThrow(()-> new SocietyNotFoundException("Society by Id : "+id+" is not found"));
    }

    public void deleteSociety(String id){

        repository.deleteById(id);
    }

}
