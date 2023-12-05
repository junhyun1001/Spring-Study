package umc.spring.dto.review;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewResponse {

    @Builder
    @Getter
    public static class ReviewResponseDto {

        private String email;

        private String body;

        private float score;

        private LocalDateTime createdAt;

    }

}
