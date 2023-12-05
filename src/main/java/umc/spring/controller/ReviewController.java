package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.dto.review.ReviewRequest;
import umc.spring.service.review.ReviewCommandService;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<?> registerReview(@PathVariable long storeId, @RequestBody ReviewRequest.ReviewDto reviewDto) {
        Review review = reviewCommandService.registerReview(storeId, reviewDto);
        return null;
    }
}
