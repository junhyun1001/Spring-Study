package umc.spring.dto.member;

import lombok.Getter;

import java.util.List;

public class MemberRequest {

    @Getter
    public static class JoinRequestDto {
        private String name;
        private String email;
        private String gender;
        private Integer birthYear;
        private Integer birthMonth;
        private Integer birthDay;
        private String address;
        private String specAddress;
        private List<Long> preferCategory;
    }

}
