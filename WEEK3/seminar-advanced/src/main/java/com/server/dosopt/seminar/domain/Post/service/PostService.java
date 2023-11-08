package com.server.dosopt.seminar.domain.Post.service;

import com.server.dosopt.seminar.domain.Member.entity.Member;
import com.server.dosopt.seminar.domain.Member.repository.MemberJpaRepository;
import com.server.dosopt.seminar.domain.Post.dto.request.PostCreateRequest;
import com.server.dosopt.seminar.domain.Post.dto.request.PostUpdateRequest;
import com.server.dosopt.seminar.domain.Post.dto.response.PostCreateResponse;
import com.server.dosopt.seminar.domain.Post.dto.response.PostGetResponse;
import com.server.dosopt.seminar.domain.Post.entity.Post;
import com.server.dosopt.seminar.domain.Post.repository.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
   private final PostJpaRepository postJpaRepository;
   private final MemberJpaRepository memberJpaRepository;
   public PostCreateResponse create(PostCreateRequest request, Long memberId) {
      Member member = memberJpaRepository.findByIdOrThrow(memberId);
      Post savedPost = postJpaRepository.save(
            Post.builder()
                  .title(request.title())
                  .content(request.content())
                  .member(member)
                  .build());
      return PostCreateResponse.of(savedPost.getId().toString());
   }

   public PostGetResponse getById(Long id) {
      Post post = postJpaRepository.findByIdOrThrow(id);
      return PostGetResponse.of(post);
   }

   public List<PostGetResponse> getPosts(Long id) {
      return postJpaRepository.findAllByMemberId(id)
            .stream()
            .map(post -> PostGetResponse.of(post))
            .toList();
   }

   @Transactional
   public void editContent(Long postId, PostUpdateRequest request) {
      Post post = postJpaRepository.findByIdOrThrow(postId);
      post.updateContent(request.content());
   }

   @Transactional
   public void deleteById(Long postId) {
      Post post = postJpaRepository.findByIdOrThrow(postId);
      postJpaRepository.delete(post);
   }
}
