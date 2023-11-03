package com.server.dosopt.seminar.domain.Member.controller;

import com.server.dosopt.seminar.domain.Member.dto.response.MemberCreateResponse;
import com.server.dosopt.seminar.domain.Member.dto.response.MemberGetResponse;
import com.server.dosopt.seminar.domain.Member.service.MemberService;
import com.server.dosopt.seminar.domain.Member.dto.request.MemberCreateRequest;
import com.server.dosopt.seminar.domain.Member.dto.request.MemberProfileUpdateRequest;
import com.server.dosopt.seminar.global.result.ResultCode;
import com.server.dosopt.seminar.global.result.ResultResponse;
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
   public ResultResponse<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
      ResultResponse<MemberGetResponse> response = ResultResponse.of(ResultCode.GET_MEMBER_PROFILE_SUCCESS,
            memberService.getMemberByIdV1(memberId));
      return response;
   }

   @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResultResponse<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
      ResultResponse<MemberGetResponse> response = ResultResponse.of(ResultCode.GET_MEMBER_PROFILE_SUCCESS,
            memberService.getMemberByIdV2(memberId));
      return response;
   }

   @GetMapping
   public ResultResponse<List<MemberGetResponse>> getMemberProfile() {
      ResultResponse<List<MemberGetResponse>> response = ResultResponse.of(ResultCode.GET_MEMBER_LIST_PROFILE_SUCCESS,
            memberService.getMembers());
      return response;
   }

   @PostMapping
   public ResultResponse<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest request) {
      ResultResponse<MemberCreateResponse> response = ResultResponse.of(ResultCode.CREATE_MEMBER_SUCCESS,
            memberService.create(request));
      return response;
   }

   @PatchMapping(value = "/{memberId}")
   public ResultResponse<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
      memberService.updateSOPT(memberId, request);
      return ResultResponse.of(ResultCode.UPDATE_MEMBER_SOPT_INFO_SUCCESS);
   }

   @DeleteMapping(value = "/{memberId}")
   public ResultResponse<Void> deleteMember(@PathVariable Long memberId) {
      memberService.deleteMember(memberId);
      return ResultResponse.of(ResultCode.DELETE_MEMBER_SUCCESS);
   }
}
