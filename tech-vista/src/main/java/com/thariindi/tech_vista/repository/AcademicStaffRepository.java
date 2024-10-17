package com.thariindi.tech_vista.repository;

import com.thariindi.tech_vista.model.AcademicStaff;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AcademicStaffRepository extends JpaRepository<AcademicStaff,String> {
    Optional<AcademicStaff> findAcademicStaffByAcademicStaffId(String id);


    @Query("SELECT s.academicStaffId FROM AcademicStaff s ORDER BY s.academicStaffId DESC")
    default String findLastAcademicStaffId(Pageable pageable) {
        return findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "academicStaffId")))
                .stream()
                .map(AcademicStaff::getAcademicStaffId)
                .findFirst()
                .orElse(null);
    }
    @Query(value = "SELECT academic_staff_id FROM academic_staff ORDER BY academic_staff_id DESC LIMIT 1", nativeQuery = true)
    String findLastAcademicStaffId();

    Optional<AcademicStaff> findAcademicStaffByNameAndAcademicEmail(String name, String academicEmail);

    AcademicStaff findAcademicStaffByAcademicEmail(String academicEmail);
}
