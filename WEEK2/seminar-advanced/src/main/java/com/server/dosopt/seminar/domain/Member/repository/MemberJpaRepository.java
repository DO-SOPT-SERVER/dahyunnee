package com.server.dosopt.seminar.domain.Member.repository;

import com.server.dosopt.seminar.domain.Member.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
   default Member findByIdOrThrow(Long id) {
      return findById(id).orElseThrow(
            () -> new EntityNotFoundException("존재하지 않는 유저입니다."));
   }
}
