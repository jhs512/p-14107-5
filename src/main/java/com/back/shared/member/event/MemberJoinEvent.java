package com.back.shared.member.event;

import com.back.boundedContext.member.domain.Member;
import com.back.shared.member.dto.MemberDto;

public record MemberJoinEvent(
        MemberDto data
) {

    public MemberJoinEvent(Member member) {
        this(new MemberDto(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                member.getPassword(),
                member.getNickname()
        ));
    }
}
