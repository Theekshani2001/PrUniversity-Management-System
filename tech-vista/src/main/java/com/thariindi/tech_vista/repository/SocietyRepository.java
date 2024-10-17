package com.thariindi.tech_vista.repository;

import com.thariindi.tech_vista.model.Society;
import com.thariindi.tech_vista.model.StudentPersonalProfile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SocietyRepository extends JpaRepository<Society,String> {
    Optional<Society> findSocietyBySocietyId(String id);

    void deleteSocietyBySocietyId(String id);

    @Query("SELECT s.societyId FROM Society s ORDER BY s.societyId DESC")
    default String findLastSocietyId(Pageable pageable) {
        return findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "societyId")))
                .stream()
                .map(Society::getSocietyId)
                .findFirst()
                .orElse(null);
    }
    @Query(value = "SELECT society_id FROM society ORDER BY society_id DESC LIMIT 1", nativeQuery = true)
    String findLastSocietyId();
}
