package com.back.boundedContext.member.domain;

import com.back.shared.member.domain.BaseMember;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER_MEMBER")
@NoArgsConstructor
@Getter
public class Member extends BaseMember {
    public Member(String username, String password, String nickname) {
        super(username, password, nickname);
    }
}
