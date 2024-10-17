package com.thariindi.tech_vista.repository;

import com.thariindi.tech_vista.model.StudentPersonalProfile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentPersonalProfileRepository extends JpaRepository<StudentPersonalProfile,String> {

    Optional<StudentPersonalProfile> findStudentPersonalProfileByStudentId(String id);

    void deleteStudentPersonalProfileByStudentId(String id);

    @Query("SELECT s.studentId FROM StudentPersonalProfile s ORDER BY s.studentId DESC")
    default String findLastStudentId(Pageable pageable) {
        return findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "studentId")))
                .stream()
                .map(StudentPersonalProfile::getStudentId)
                .findFirst()
                .orElse(null);
    }
    @Query(value = "SELECT student_id FROM student_personal_profile ORDER BY student_id DESC LIMIT 1", nativeQuery = true)
    String findLastStudentId();
}
