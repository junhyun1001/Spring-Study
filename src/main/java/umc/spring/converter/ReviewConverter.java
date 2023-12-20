package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.dto.review.ReviewRequest;
import umc.spring.dto.review.ReviewResponse;

import java.util.List;

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

    public static ReviewResponse.ReviewPageDto toReviewPreviewDto(Review review) {
        return ReviewResponse.ReviewPageDto.builder()
                .ownerNickname(review.getMember().getNickname())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponse.ReviewPageListDto toReviewPreviewListDto(Page<Review> reviewList) {

        List<ReviewResponse.ReviewPageDto> reviewPageDtoList = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDto).toList();

        return ReviewResponse.ReviewPageListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPageDtoList.size())
                .reviewList(reviewPageDtoList)
                .build();

    }

}
