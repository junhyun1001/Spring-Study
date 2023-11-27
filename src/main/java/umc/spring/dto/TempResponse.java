package umc.spring.dto;

import lombok.Builder;
import lombok.Getter;

public class TempResponse {

    @Builder
    @Getter
    public static class TempTestDto {
        String testString;
    }

}
