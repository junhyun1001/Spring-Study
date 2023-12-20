package umc.spring.converter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
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

    public static ReviewResponse.ReviewDto toReviewDto(Review review) {
        return ReviewResponse.ReviewDto.builder()
                .ownerNickname(review.getMember().getNickname())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponse.ReviewPageListDto toReviewPageListDto(Page<Review> reviewList) {

        List<ReviewResponse.ReviewDto> reviewDtoList = reviewList.stream()
                .map(ReviewConverter::toReviewDto).toList();

        return ReviewResponse.ReviewPageListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewDtoList.size())
                .reviewList(reviewDtoList)
                .build();

    }

    public static ReviewResponse.ReviewSliceListDto toReviewSliceListDto(Slice<Review> reviewList) {

        List<ReviewResponse.ReviewDto> reviewDtoList = reviewList.stream()
                .map(ReviewConverter::toReviewDto).toList();

        return ReviewResponse.ReviewSliceListDto.builder()
                .currentSliceNumber(reviewList.getNumber())
                .sliceSize(reviewList.getSize())
                .numberOfElements(reviewList.getNumberOfElements())
                .hasContent(reviewList.hasContent())
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .hasNext(reviewList.hasNext())
                .hasPrevious(reviewList.hasPrevious())
                .reviewList(reviewDtoList)
                .build();

    }

}
