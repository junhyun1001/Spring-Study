package umc.spring.dto.review;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponse {

    @Builder
    @Getter
    public static class ReviewResponseDto {

        private String nickname;

        private String body;

        private float score;

        private LocalDateTime createdAt;

    }

    @Builder
    @Getter
    public static class ReviewPreviewDto {

        private String ownerNickname;

        private Float score;

        private String body;

        private LocalDate createdAt;

    }

    @Builder
    @Getter
    public static class ReviewPreviewListDto {

        private List<ReviewPreviewDto> reviewList;

        private Integer listSize;

        private Integer totalPage;

        private Long totalElements;

        private Boolean isFirst;

        private Boolean isLast;

    }

}
