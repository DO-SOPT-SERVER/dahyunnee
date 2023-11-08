package com.server.dosopt.seminar.domain.Post.repository;

import com.server.dosopt.seminar.domain.Post.entity.Post;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
   List<Post> findAllByMemberId(Long memberId);

   default Post findByIdOrThrow(Long id) {
      return findById(id).orElseThrow(
            () -> new EntityNotFoundException("존재하지 않는 게시글입니다."));
   }
}
