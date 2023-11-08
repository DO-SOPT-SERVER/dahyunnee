package com.server.dosopt.seminar.domain.Post.service;

import com.server.dosopt.seminar.domain.Member.entity.Member;
import com.server.dosopt.seminar.domain.Member.repository.MemberJpaRepository;
import com.server.dosopt.seminar.domain.Post.dto.request.PostCreateRequest;
import com.server.dosopt.seminar.domain.Post.dto.request.PostUpdateRequest;
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
@Transactional(readOnly = true)  // PostService에서 일단 read만 가능하게 설정 후 각 메소드에서 따로 세부설정 가능
public class PostService {
   private final PostJpaRepository postJpaRepository;
   private final MemberJpaRepository memberJpaRepository;
   public String create(PostCreateRequest request, Long memberId) {
      Member member = memberJpaRepository.findByIdOrThrow(memberId);
      Post post = Post.builder()
            .title(request.title())
            .content(request.content())
            .member(member)
            .build();      // 비영속 상태
      Post savedPost = postJpaRepository.save(post); // save를 통해 저장 - void 또는 만든 객체 리턴시킴
      return savedPost.getId().toString();
   }

   public PostGetResponse getById(Long id) {
      Post post = postJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
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
      Post post = postJpaRepository.findById(postId)
            .orElseThrow(() -> new EntityNotFoundException());
      post.updateContent(request.content());
   }

   @Transactional
   public void deleteById(Long postId) {
      Post post = postJpaRepository.findById(postId)
            .orElseThrow(() -> new EntityNotFoundException());
      postJpaRepository.delete(post);
   }
}
