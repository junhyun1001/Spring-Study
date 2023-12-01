package umc.spring.service.member;

import umc.spring.domain.Member;
import umc.spring.dto.member.MemberRequest;

public interface MemberCommandService {

    Member joinMember(MemberRequest.JoinRequestDto joinRequestDto);
}
