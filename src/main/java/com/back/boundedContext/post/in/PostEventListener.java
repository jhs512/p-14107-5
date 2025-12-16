package com.back.boundedContext.post.in;

import com.back.boundedContext.post.facade.PostFacade;
import com.back.shared.member.event.MemberJoinEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class PostEventListener {
    private final PostFacade postFacade;
    private final ObjectMapper objectMapper;

    public void handlePostEvent(String message) throws Exception {
        MemberJoinEvent event = objectMapper.readValue(message, MemberJoinEvent.class);
        postFacade.syncMember(event);
    }
}
