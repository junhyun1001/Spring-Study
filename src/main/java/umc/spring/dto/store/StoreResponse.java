package umc.spring.dto.store;

import lombok.Builder;
import lombok.Getter;

public class StoreResponse {

    @Builder
    @Getter
    public static class RegisterResultDto {

        private String fullAddress;

    }

}
