package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.dto.member.MemberRequest;
import umc.spring.dto.member.MemberResponse;
import umc.spring.service.member.MemberCommandService;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping
    public ApiResponse<MemberResponse.JoinResponseDto> join(@RequestBody @Validated MemberRequest.JoinRequestDto joinRequestDto) {
        Member member = memberCommandService.joinMember(joinRequestDto);
        return ApiResponse.onSuccess(MemberConverter.toJoinResponseDto(member));
    }

}
