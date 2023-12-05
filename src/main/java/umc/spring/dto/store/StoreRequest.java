package umc.spring.dto.store;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequest {

    @Getter
    public static class RegisterDto {

        @NotBlank
        private String name; // 식당 이름

        @NotBlank
        private String ctpvNm; // 시도명

        @NotBlank
        private String sggNm; // 시군명

        @NotBlank
        private String emdNm; // 읍면동명

        @NotBlank
        private String address; // 나머지 상세 주소

    }

}
