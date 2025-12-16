package com.back.boundedContext.post.facade;

import com.back.boundedContext.post.domain.PostMember;
import com.back.boundedContext.post.out.PostMemberRepository;
import com.back.shared.member.event.MemberJoinEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("post")
@Service
@RequiredArgsConstructor
public class PostFacade {
    private PostMemberRepository postMemberRepository;

    public void syncMember(MemberJoinEvent event) {
        PostMember postMember = new PostMember(
                event.data().id(),
                event.data().createDate(),
                event.data().modifyDate(),
                event.data().username(),
                event.data().password(),
                event.data().nickname()
        );

        postMemberRepository.save(postMember);
    }
}
