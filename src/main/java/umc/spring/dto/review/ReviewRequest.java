package umc.spring.dto.review;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class ReviewDto {

        @NotBlank
        private String body; // 리뷰 내용


        private float score; // 가게 점수

    }

}
