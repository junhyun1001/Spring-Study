package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.dto.member.MemberRequest;
import umc.spring.exception.food_category.FoodCategoryHandler;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Transactional
    @Override
    public Member joinMember(MemberRequest.JoinRequestDto joinRequestDto) {

        // 1. 받아온 joinRequestDto로 Member 객체를 만든다.
        Member member = MemberConverter.toMember(joinRequestDto);

        // 2. joinRequestDto에서 받아온 foodCategory의 id값으로 foodCategoryRepository에서 FoodCategory를 찾는다.
        // 만약 해당 id가 존재하지 않을 경우 FoodCategoryHandler롤 에러를 ErrorStatus를 넘긴다.
        List<FoodCategory> foodCategoryList = new ArrayList<>();
        for (Long foodCategoryId : joinRequestDto.getPreferCategory()) {
            foodCategoryList.add(foodCategoryRepository.findById(foodCategoryId).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)));
        }

        // 3. 2번에서 찾은 foodCategoryList를 List<MemberPrefer>객체로 만들어준다.
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPrefer(foodCategoryList);

        // 4. MemberPrefer에 회원의 연관관계 설정을 해준다.
        for (MemberPrefer memberPrefer : memberPreferList) {
            memberPrefer.setMember(member);
        }

        // DB에 저장(영속성 컨텍스트에 저장되었다가 commit() 수행 시 DB에 저장됨)
        return memberRepository.save(member);
    }
}
