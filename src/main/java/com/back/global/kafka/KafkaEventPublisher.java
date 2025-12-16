package com.back.global.kafka;

import com.back.shared.member.event.MemberJoinEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class KafkaEventPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void send(String topic, Object data) {
        kafkaTemplate.send(topic, objectMapper.writeValueAsString(data));
    }
}
