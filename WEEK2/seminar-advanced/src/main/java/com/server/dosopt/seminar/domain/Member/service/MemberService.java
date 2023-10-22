package com.server.dosopt.seminar.domain.Member.service;

import com.server.dosopt.seminar.domain.Member.dto.response.MemberCreateResponse;
import com.server.dosopt.seminar.domain.Member.entity.Member;
import com.server.dosopt.seminar.domain.Member.entity.SOPT;
import com.server.dosopt.seminar.domain.Member.dto.request.MemberCreateRequest;
import com.server.dosopt.seminar.domain.Member.dto.request.MemberProfileUpdateRequest;
import com.server.dosopt.seminar.domain.Member.dto.response.MemberGetResponse;
import com.server.dosopt.seminar.domain.Member.repository.MemberJpaRepository;
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
      return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
   }

   public List<MemberGetResponse> getMembers() {
      return memberJpaRepository.findAll()
            .stream()
            .map(MemberGetResponse::of)
            .collect(Collectors.toList());
   }

   @Transactional
   public MemberCreateResponse create(MemberCreateRequest request) {
      Member member = Member.builder()
            .name(request.name())
            .nickname(request.nickname())
            .age(request.age())
            .sopt(request.sopt())
            .build();
      return MemberCreateResponse.of(memberJpaRepository.save(member).getId().toString());
   }

   @Transactional
   public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
      Member member = memberJpaRepository.findByIdOrThrow(memberId);
      member.updateSOPT(new SOPT(request.generation(), request.part()));
   }

   @Transactional
   public void deleteMember(Long memberId) {
      Member member = memberJpaRepository.findByIdOrThrow(memberId);
      memberJpaRepository.delete(member);
   }
}
