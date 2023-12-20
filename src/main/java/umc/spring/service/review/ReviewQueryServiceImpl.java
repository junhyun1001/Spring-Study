package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.exception.handler.MemberHandler;
import umc.spring.exception.handler.StoreHandler;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<Review> getReviewList(long storeId, int page) {

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Sort.TypedSort<Review> reviewTypedSort = Sort.sort(Review.class);
        Sort sort = reviewTypedSort.by(Review::getScore).descending();

        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10, sort));

    }

    @Override
    public Slice<Review> getMyReviewList(long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return reviewRepository.findAllByMember(member, PageRequest.of(0, 2));
    }
}
