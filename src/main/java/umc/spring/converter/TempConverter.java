package umc.spring.converter;

import umc.spring.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDto toTempTestDto() {
        return TempResponse.TempTestDto.builder()
                .testString("This is Test!!!")
                .build();
    }

    public static TempResponse.TempExceptionDto toTempExceptionDto(int flag) {
        return TempResponse.TempExceptionDto.builder()
                .flag(flag)
                .build();
    }
}
