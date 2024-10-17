package com.thariindi.tech_vista.service;

import com.thariindi.tech_vista.exception.AdminNotFoundException;
import com.thariindi.tech_vista.exception.StudentAcademicProfileNotFoundException;
import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.model.StudentAcademicProfile;
import com.thariindi.tech_vista.repository.StudentAcademicProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAcademicProfileService {

    private final StudentAcademicProfileRepository repository;
    @Autowired
    public StudentAcademicProfileService(StudentAcademicProfileRepository repository) {
        this.repository = repository;
    }

    public StudentAcademicProfile addStudentAcademicProfile(StudentAcademicProfile profile){
        String lastAcademicId = repository.findLastAcademicId();
        String newAcademicId = generateNextId(lastAcademicId);
        profile.setAcademicId(newAcademicId);
        return repository.save(profile);
    }

    private String generateNextId(String lastAcademicId) {
        if (lastAcademicId == null) {
            return "SA-0001";
        }
        int idNumber = Integer.parseInt(lastAcademicId.substring(3)) + 1;
        return String.format("SA-%04d", idNumber);
    }

    public StudentAcademicProfile fetchStudentAcademicProfileByAcademicMail(String email){
        return repository.findStudentAcademicProfileByAcademicMail(email);
    }

    public StudentAcademicProfile loginStudent(String name, String email){
        return repository.findStudentAcademicProfileByNameAndAcademicMail(name,email).orElseThrow(() -> new StudentAcademicProfileNotFoundException("student by email "+email+" and name "+name+" was not found"));
    }



    public List<StudentAcademicProfile> findAllStudentAcademicProfiles(){
        return repository.findAll();
    }

    public StudentAcademicProfile updateStudentAcademicProfile(StudentAcademicProfile profile){
        return repository.save(profile);
    }

    public StudentAcademicProfile findStudentAcademicProfile(String name){
        return repository.findStudentAcademicProfileByName(name).
                orElseThrow(()-> new StudentAcademicProfileNotFoundException("Student Academic Profile by name : "+name+" is not found"));
    }

    public void deleteStudentAcademicProfile(String id){
        repository.deleteById(id);
    }

}
