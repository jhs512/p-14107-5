package com.back.boundedContext.post.out;

import com.back.boundedContext.post.domain.PostMember;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Profile("post")
public interface PostMemberRepository extends JpaRepository<PostMember, Integer> {
    Optional<PostMember> findByUsername(String username);
}
