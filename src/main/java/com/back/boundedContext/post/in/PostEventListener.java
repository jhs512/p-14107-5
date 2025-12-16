package com.back.boundedContext.post.in;

import com.back.boundedContext.post.facade.PostFacade;
import com.back.shared.member.event.MemberJoinEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Profile("post")
@Component
@RequiredArgsConstructor
public class PostEventListener {
    private final PostFacade postFacade;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "member-join-topic", groupId = "post")
    public void handlePostEvent(String message) {
        MemberJoinEvent event = objectMapper.readValue(message, MemberJoinEvent.class);

        System.out.println(event);
    }
}
