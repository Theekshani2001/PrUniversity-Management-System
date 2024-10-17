package com.thariindi.tech_vista.repository;
import com.thariindi.tech_vista.model.Society;
import com.thariindi.tech_vista.model.SocietyMember;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SocietyMemberRepository extends JpaRepository<SocietyMember,String> {

    @Query("SELECT s.societyMemberId FROM SocietyMember s ORDER BY s.societyMemberId DESC")
    default String findLastSocietyMemberId(Pageable pageable) {
        return findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "societyMemberId")))
                .stream()
                .map(SocietyMember::getSocietyMemberId)
                .findFirst()
                .orElse(null);
    }
    @Query(value = "SELECT society_member_id FROM society_member ORDER BY society_member_id DESC LIMIT 1", nativeQuery = true)
    String findLastSocietyMemberId();
}
