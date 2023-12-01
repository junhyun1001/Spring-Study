package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPrefer(List<FoodCategory> foodCategoryList) {
        List<MemberPrefer> memberPreferList = new ArrayList<>();

        for (FoodCategory foodCategory : foodCategoryList) {
            memberPreferList.add(
                    MemberPrefer.builder()
                            .foodCategory(foodCategory)
                            .build()
            );
        }

        return memberPreferList;
    }

}
