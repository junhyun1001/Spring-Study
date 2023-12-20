package umc.spring.service.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import umc.spring.domain.Review;

public interface ReviewQueryService {

    Page<Review> getReviewList(long storeId, int page);

    Slice<Review> getMyReviewList(long memberId);

}
