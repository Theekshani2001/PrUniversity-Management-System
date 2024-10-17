package com.thariindi.tech_vista.repository;

import com.thariindi.tech_vista.model.Admin;
import com.thariindi.tech_vista.model.StudentAcademicProfile;
import com.thariindi.tech_vista.model.StudentPersonalProfile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentAcademicProfileRepository extends JpaRepository<StudentAcademicProfile,String> {

    Optional<StudentAcademicProfile> findStudentAcademicProfileByName(String name);

    public StudentAcademicProfile findStudentAcademicProfileByAcademicMail(String academicMail);

    void deleteStudentAcademicProfileByAcademicMail(String email);

    @Query("SELECT s.academicId FROM StudentAcademicProfile s ORDER BY s.academicId DESC")
    default String findLastAcademicId(Pageable pageable) {
        return findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "academicId")))
                .stream()
                .map(StudentAcademicProfile::getAcademicId)
                .findFirst()
                .orElse(null);
    }
    @Query(value = "SELECT academic_id FROM student_academic_profile ORDER BY academic_id DESC LIMIT 1", nativeQuery = true)
    String findLastAcademicId();

    Optional<StudentAcademicProfile> findStudentAcademicProfileByNameAndAcademicMail(String name, String email);
}
