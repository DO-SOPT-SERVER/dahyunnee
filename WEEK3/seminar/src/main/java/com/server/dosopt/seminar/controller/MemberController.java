package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.request.MemberCreateRequest;
import com.server.dosopt.seminar.dto.request.MemberProfileUpdateRequest;
import com.server.dosopt.seminar.dto.response.MemberGetResponse;
import com.server.dosopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
   private final MemberService memberService;

   @GetMapping(value = "/{memberId}")
   public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
      return ResponseEntity.ok(memberService.getMemberByIdV1(memberId));
   }

   // MediaType.APPLICATION_JSON_VALUE => application/json
   // consumes => 클라에서 보내는 요청 타입
   @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
      return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
   }

   @GetMapping
   public ResponseEntity<List<MemberGetResponse>> getMemberProfile() {
      return ResponseEntity.ok(memberService.getMembers());
   }

   @PostMapping
   public ResponseEntity<MemberGetResponse> createMember(@RequestBody MemberCreateRequest request) {
      URI location = URI.create("api/member/" + memberService.create(request));
      return ResponseEntity.created(location).build();
   }

   @PatchMapping(value = "/{memberId}")
   public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
      memberService.updateSOPT(memberId, request);
      return ResponseEntity.noContent().build();
   }

   @DeleteMapping(value = "/{memberId}")
   public ResponseEntity deleteMember(@PathVariable Long memberId) {
      memberService.deleteMember(memberId);
      return ResponseEntity.noContent().build();
   }
}
