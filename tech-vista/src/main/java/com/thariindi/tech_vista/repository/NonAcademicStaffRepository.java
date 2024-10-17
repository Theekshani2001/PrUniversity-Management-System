package com.thariindi.tech_vista.repository;

import com.thariindi.tech_vista.model.AcademicStaff;
import com.thariindi.tech_vista.model.NonAcademicStaff;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NonAcademicStaffRepository extends JpaRepository<NonAcademicStaff,String > {
    Optional<NonAcademicStaff> findNonAcademicStaffByNonAcademicStaffId(String id);

    @Query("SELECT s.nonAcademicStaffId FROM NonAcademicStaff s ORDER BY s.nonAcademicStaffId DESC")
    default String findLastNonAcademicStaffId(Pageable pageable) {
        return findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "nonAcademicStaffId")))
                .stream()
                .map(NonAcademicStaff::getNonAcademicStaffId)
                .findFirst()
                .orElse(null);
    }
    @Query(value = "SELECT non_academic_staff_id FROM non_academic_staff ORDER BY non_academic_staff_id DESC LIMIT 1", nativeQuery = true)
    String findLastNonAcademicStaffId();

    Optional<NonAcademicStaff> findNonAcademicStaffByNameAndNonAcademicStaffMail(String name, String nonAcademicStaffMail);
}
