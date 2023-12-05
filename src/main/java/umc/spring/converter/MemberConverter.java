package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.dto.member.MemberRequest;
import umc.spring.dto.member.MemberResponse;

import java.util.ArrayList;

public class MemberConverter {

    public static Member toMember(MemberRequest.JoinRequestDto joinRequestDto) {

        Gender gender = switch (joinRequestDto.getGender()) {
            case "MALE" -> Gender.MALE;
            case "FEMALE" -> Gender.FEMALE;
            default -> null;
        };

        return Member.builder()
                .name(joinRequestDto.getName())
                .nickname(joinRequestDto.getNickname())
                .email(joinRequestDto.getEmail())
                .gender(gender)
                .address(joinRequestDto.getAddress())
                .specAddress(joinRequestDto.getSpecAddress())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponse.JoinResponseDto toJoinResponseDto(Member member) {
        return MemberResponse.JoinResponseDto.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

}
