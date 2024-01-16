package umc.spring.dto.member;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberResponse {

    @Builder
    @Getter
    public static class JoinResponseDto {
        Long memberId;
        LocalDateTime createdAt;
    }

}
