package com.thariindi.tech_vista.service;

import com.thariindi.tech_vista.exception.StudentPersonalProfileNotFoundException;
import com.thariindi.tech_vista.model.StudentPersonalProfile;
import com.thariindi.tech_vista.repository.StudentPersonalProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPersonalProfileService {
    private final StudentPersonalProfileRepository repository;
    @Autowired
    public StudentPersonalProfileService(StudentPersonalProfileRepository repository) {
        this.repository = repository;
    }

    public StudentPersonalProfile addStudentPersonalProfile(StudentPersonalProfile profile){
        String lastStudentId = repository.findLastStudentId();
        String newStudentId = generateNextId(lastStudentId);
        profile.setStudentId(newStudentId);
        return repository.save(profile);
    }

    private String generateNextId(String lastAcademicId) {
        if (lastAcademicId == null) {
            return "SP-0001";
        }
        int idNumber = Integer.parseInt(lastAcademicId.substring(3)) + 1;
        return String.format("SP-%04d", idNumber);
    }


    public List<StudentPersonalProfile> findAllStudentPersonalProfiles(){
        return repository.findAll();
    }

    public StudentPersonalProfile updateStudentPersonalProfile(StudentPersonalProfile profile){
        return repository.save(profile);
    }

    public StudentPersonalProfile findStudentPersonalProfile(String id){
        return repository.findStudentPersonalProfileByStudentId(id).
                orElseThrow(()-> new StudentPersonalProfileNotFoundException("Student Personal Profile by Id : "+id+" is not found"));
    }

    public void deleteStudentPersonalProfile(String id){

        repository.deleteById(id);
    }

}
