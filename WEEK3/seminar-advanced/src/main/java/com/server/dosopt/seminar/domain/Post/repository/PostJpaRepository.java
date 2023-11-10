package com.server.dosopt.seminar.domain.Post.repository;

import com.server.dosopt.seminar.domain.Post.entity.Post;
import com.server.dosopt.seminar.global.exception.domain.PostException;
import com.server.dosopt.seminar.global.error.CustomErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
   List<Post> findAllByMemberId(Long memberId);

   default Post findByIdOrThrow(Long id) {
      return findById(id).orElseThrow(
            () -> new PostException(CustomErrorCode.POST_NOT_FOUND));
   }
}
