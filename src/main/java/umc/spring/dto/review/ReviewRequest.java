package umc.spring.dto.review;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class ReviewDto {

        @NotBlank
        private String body; // 리뷰 내용

        @NotBlank
        private String email; // 리뷰 작성자

        @Digits(integer = 1, fraction = 1, message = "최대 1자리의 소수점을 입력하세요.")
        @DecimalMin(value = "0.0", message = "0.0 이상의 값을 입력하세요.")
        @DecimalMax(value = "5.0", message = "5.0 이하의 값을 입력하세요.")
        private float score; // 가게 점수

    }

}
