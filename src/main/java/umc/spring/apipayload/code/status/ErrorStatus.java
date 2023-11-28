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

    // TempException 응답
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP401", "flag가 2입니다.");

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
