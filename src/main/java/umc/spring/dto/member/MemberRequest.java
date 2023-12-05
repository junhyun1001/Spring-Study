package umc.spring.dto.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistGender;

import java.util.List;

public class MemberRequest {

    @Getter
    public static class JoinRequestDto {
        @NotBlank
        private String name;
        @Email
        private String email;
        @ExistGender
        private String gender;
        @NotNull
        private Integer birthYear;
        @NotNull
        private Integer birthMonth;
        @NotNull
        private Integer birthDay;
        @Size(min = 5, max = 12)
        private String address;
        @NotBlank
        private String specAddress;
        @ExistCategories
        @Size(min = 1, max = 5)
        private List<Long> preferCategory;
    }

}
