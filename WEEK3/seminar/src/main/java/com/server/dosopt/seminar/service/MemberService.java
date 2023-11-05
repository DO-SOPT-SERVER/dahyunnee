package com.server.dosopt.seminar.service;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.domain.SOPT;
import com.server.dosopt.seminar.dto.request.MemberCreateRequest;
import com.server.dosopt.seminar.dto.request.MemberProfileUpdateRequest;
import com.server.dosopt.seminar.dto.response.MemberGetResponse;
import com.server.dosopt.seminar.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

   private final MemberJpaRepository memberJpaRepository;

   public MemberGetResponse getMemberByIdV1(Long id) {
      Member member = memberJpaRepository.findById(id).get();
      return MemberGetResponse.of(member);
   }

   public MemberGetResponse getMemberByIdV2(Long memberId) {
      /*
      Member member = memberJpaRepository.findById(memberId)
            .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 유저입니다"));
      */
      return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
   }

   public List<MemberGetResponse> getMembers() {
      return memberJpaRepository.findAll()
            .stream()
            // .map(member -> MemberGetResponse.of(member))
            .map(MemberGetResponse::of)
            .collect(Collectors.toList());
   }

   // class보다 method 위에 붙인 @Transactional이 우선순위 높음.
   @Transactional
   public String create(MemberCreateRequest request) {
      /*
        Member member = Member.builder()
            .name(request.getName())
            .nickname(request.getNickname())
            .age(request.getAge())
            .sopt(request.getSopt())
            .build();
       */

      // MemberCreateRequest가 레코드 타입일 경우
      Member member = Member.builder()
            .name(request.name())
            .nickname(request.nickname())
            .age(request.age())
            .sopt(request.sopt())
            .build();
      return memberJpaRepository.save(member).getId().toString();
   }

   @Transactional
   public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
      Member member = memberJpaRepository.findByIdOrThrow(memberId);
      member.updateSOPT(new SOPT(request.getGeneration(), request.getPart()));
   }

   @Transactional
   public void deleteMember(Long memberId) {
      Member member = memberJpaRepository.findByIdOrThrow(memberId);
      memberJpaRepository.delete(member);
   }
}
