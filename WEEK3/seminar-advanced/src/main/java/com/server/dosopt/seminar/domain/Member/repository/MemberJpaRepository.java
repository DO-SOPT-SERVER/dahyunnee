package com.server.dosopt.seminar.domain.Member.repository;

import com.server.dosopt.seminar.domain.Member.entity.Member;
import com.server.dosopt.seminar.global.error.CustomErrorCode;
import com.server.dosopt.seminar.global.exception.domain.MemberException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
   default Member findByIdOrThrow(Long id) {
      return findById(id).orElseThrow(
            () -> new MemberException(CustomErrorCode.MEMBER_NOT_FOUND));
   }
}
