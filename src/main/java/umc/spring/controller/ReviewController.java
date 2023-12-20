package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.dto.review.ReviewRequest;
import umc.spring.dto.review.ReviewResponse;
import umc.spring.service.review.ReviewCommandService;
import umc.spring.service.review.ReviewQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.validator.PageValidator;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Validated
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/stores/{storeId}")
    public ApiResponse<ReviewResponse.ReviewResponseDto> registerReview(@PathVariable long storeId, @RequestBody @Valid ReviewRequest.ReviewDto reviewDto) {
        Review review = reviewCommandService.registerReview(storeId, reviewDto);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDto(review));
    }

    @GetMapping("/stores/{storeId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses(
            {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            }
    )
    @Parameters(
            {
                    @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다.")
            }
    )
    public ApiResponse<ReviewResponse.ReviewPageListDto> getReviewList(@PathVariable long storeId, @RequestParam @CheckPage int page) {
        page = PageValidator.adjustPageNumber(page);
        Page<Review> reviewList = reviewQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDto(reviewList));
    }

}
