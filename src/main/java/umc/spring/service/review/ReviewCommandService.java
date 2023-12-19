package umc.spring.service.review;

import umc.spring.domain.Review;
import umc.spring.dto.review.ReviewRequest;

public interface ReviewCommandService {

    Review registerReview(long storeId, ReviewRequest.ReviewDto reviewDto);

}
