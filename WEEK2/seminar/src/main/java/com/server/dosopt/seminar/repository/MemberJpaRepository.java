package com.server.dosopt.seminar.repository;

import com.server.dosopt.seminar.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
   // default 또는 static 키워드를 붙여 구현부 작성 가능
   default Member findByIdOrThrow(Long id) {
      return findById(id).orElseThrow(
            () -> new EntityNotFoundException("존재하지 않는 유저입니다."));
   }
}
