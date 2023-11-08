package com.server.dosopt.seminar.domain.Post.controller;

import com.server.dosopt.seminar.domain.Post.dto.request.PostCreateRequest;
import com.server.dosopt.seminar.domain.Post.dto.request.PostUpdateRequest;
import com.server.dosopt.seminar.domain.Post.dto.response.PostGetResponse;
import com.server.dosopt.seminar.domain.Post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
   private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
   private final PostService postService;
   @PostMapping
   public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                          @RequestBody PostCreateRequest request) {
      URI location = URI.create("/api/posts/" + postService.create(request, memberId));
      return ResponseEntity.created(location).build();
   }

   @GetMapping("/{postId}")
   public ResponseEntity<PostGetResponse> getPostById(@PathVariable("postId") Long id) {
      return ResponseEntity.ok(postService.getById(id));
   }

   @GetMapping
   public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long id) {
      return ResponseEntity.ok(postService.getPosts(id));
   }

   @PatchMapping("/{postId}")
   public ResponseEntity<Void> updatePost(@PathVariable Long postId,
                                          @RequestBody PostUpdateRequest request) {
      postService.editContent(postId, request);
      return ResponseEntity.noContent().build();
   }

   @DeleteMapping("/{postId}")
   public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
      postService.deleteById(postId);
      return ResponseEntity.noContent().build();
   }
}
