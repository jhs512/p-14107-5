package com.back.boundedContext.post.domain;

import com.back.shared.member.domain.BaseMember;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "POST_MEMBER")
@NoArgsConstructor
@Getter
public class PostMember extends BaseMember {
    public PostMember(int id, LocalDateTime createDate, LocalDateTime modifyDate, String username, String password, String nickname) {
        super(username, password, nickname);
        this.setId(id);
        this.setCreateDate(createDate);
        this.setModifyDate(modifyDate);
    }
}
