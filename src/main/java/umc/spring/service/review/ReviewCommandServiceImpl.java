package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.review.ReviewRequest;
import umc.spring.exception.handler.StoreHandler;
import umc.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final StoreRepository storeRepository;

    @Override
    public Review registerReview(long storeId, ReviewRequest.ReviewDto reviewDto) {



        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        return null;
    }
}
