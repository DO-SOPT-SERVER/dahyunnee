package com.server.dosopt.seminar.domain.Post.controller;

import com.server.dosopt.seminar.domain.Post.dto.request.PostCreateRequest;
import com.server.dosopt.seminar.domain.Post.dto.request.PostUpdateRequest;
import com.server.dosopt.seminar.domain.Post.dto.response.PostCreateResponse;
import com.server.dosopt.seminar.domain.Post.dto.response.PostGetResponse;
import com.server.dosopt.seminar.domain.Post.service.PostService;
import com.server.dosopt.seminar.global.result.ResultCode;
import com.server.dosopt.seminar.global.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
   private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
   private final PostService postService;
   @PostMapping
   public ResultResponse<PostCreateResponse> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                          @RequestBody PostCreateRequest request) {
      return ResultResponse.of(ResultCode.CREATE_POST_SUCCESS,
            postService.create(request, memberId));
   }

   @GetMapping("/{postId}")
   public ResultResponse<PostGetResponse> getPostById(@PathVariable("postId") Long id) {
      return ResultResponse.of(ResultCode.GET_POST_SUCCESS, postService.getById(id));
   }

   @GetMapping
   public ResultResponse<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long id) {
      return ResultResponse.of(ResultCode.GET_MEMBER_POST_LIST_SUCCESS, postService.getPosts(id));
   }

   @PatchMapping("/{postId}")
   public ResultResponse<Void> updatePost(@PathVariable Long postId,
                                          @RequestBody PostUpdateRequest request) {
      postService.editContent(postId, request);
      return ResultResponse.of(ResultCode.UPDATE_POST_SUCCESS);
   }

   @DeleteMapping("/{postId}")
   public ResultResponse<Void> deletePost(@PathVariable Long postId) {
      postService.deleteById(postId);
      return ResultResponse.of(ResultCode.DELETE_MEMBER_SUCCESS);
   }
}
