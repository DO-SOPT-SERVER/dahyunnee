package com.server.dosopt.seminar.domain.Post.repository;

import com.server.dosopt.seminar.domain.Post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
   List<Post> findAllByMemberId(Long memberId);
}
