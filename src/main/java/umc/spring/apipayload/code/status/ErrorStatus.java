package umc.spring.apipayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apipayload.code.BaseCode;
import umc.spring.apipayload.code.ReasonDto;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {

    // 일반적인 에러 응답
    INTERNER_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),

    // TempException 응답
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP401", "flag가 2입니다."),

    // FoodCategory 응답
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD_CATEGORY401", "존재하지 않는 음식 카테고리 입니다."),

    // Region 응답
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION401", "존재하지 않는 지역입니다."),

    // Store 응답
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE401", "존재하지 않는 가게입니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }
}
