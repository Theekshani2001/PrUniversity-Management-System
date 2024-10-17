package com.thariindi.tech_vista.service;

import com.thariindi.tech_vista.exception.SocietyMemberNotFoundException;
import com.thariindi.tech_vista.model.SocietyMember;
import com.thariindi.tech_vista.repository.SocietyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyMemberService {
    private final SocietyMemberRepository repository;
    @Autowired
    public SocietyMemberService(SocietyMemberRepository repository) {
        this.repository = repository;
    }

    public SocietyMember addSocietyMember(SocietyMember societyMember){
        String lastSocietyMemberId = repository.findLastSocietyMemberId();
        String newSocietyMemberId = generateNextId(lastSocietyMemberId);
        societyMember.setSocietyMemberId(newSocietyMemberId);
        return repository.save(societyMember);
    }
    private String generateNextId(String lastSocietyMemberId) {
        if (lastSocietyMemberId == null) {
            return "SOM-0001";
        }
        int idNumber = Integer.parseInt(lastSocietyMemberId.substring(4)) + 1;
        return String.format("SOM-%04d", idNumber);
    }

    public List<SocietyMember> findAllSocietyMembers(){
        return repository.findAll();
    }

    public SocietyMember updateSocietyMember(SocietyMember societyMember){
        return repository.save(societyMember);
    }

    public SocietyMember findSocietyMember(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new SocietyMemberNotFoundException("Society Member by Id : " + id + " is not found"));
    }

    public void deleteSocietyMember(String id) {
        repository.deleteById(id);
    }

}
