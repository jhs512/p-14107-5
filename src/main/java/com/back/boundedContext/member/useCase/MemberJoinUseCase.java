package com.back.boundedContext.member.useCase;

import com.back.boundedContext.member.domain.Member;
import com.back.boundedContext.member.out.MemberRepository;
import com.back.global.exception.DomainException;
import com.back.global.kafka.KafkaEventPublisher;
import com.back.shared.member.event.MemberJoinEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Profile("member")
@Service
@RequiredArgsConstructor
public class MemberJoinUseCase {
    private final MemberRepository memberRepository;
    private final KafkaEventPublisher kafkaEventPublisher;

    public Member join(String username, String password, String nickname) {
        memberRepository.findByUsername(username).ifPresent(_ -> {
            throw new DomainException("409-1", "이미 존재하는 username 입니다.");
        });

        Member member = memberRepository.save(new Member(username, password, nickname));

        kafkaEventPublisher.send("member-join-topic", new MemberJoinEvent(member));

        return member;
    }
}
