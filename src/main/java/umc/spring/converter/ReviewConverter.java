package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.dto.review.ReviewRequest;
import umc.spring.dto.review.ReviewResponse;

public class ReviewConverter {

    public static Review toReview(ReviewRequest.ReviewDto reviewDto) {
        return Review.builder()
                .body(reviewDto.getBody())
                .score(reviewDto.getScore())
                .build();
    }

    public static ReviewResponse.ReviewResponseDto toReviewResponseDto(Review review) {
        return ReviewResponse.ReviewResponseDto.builder()
                .nickname(review.getMember().getNickname())
                .body(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .build();
    }

}
