package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.dto.review.ReviewRequest;
import umc.spring.dto.review.ReviewResponse;
import umc.spring.service.review.ReviewCommandService;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/stores/{storeId}")
    public ApiResponse<ReviewResponse.ReviewResponseDto> registerReview(@PathVariable long storeId, @RequestBody @Valid ReviewRequest.ReviewDto reviewDto) {
        Review review = reviewCommandService.registerReview(storeId, reviewDto);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDto(review));
    }
}
