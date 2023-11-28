package umc.spring.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.spring.apipayload.ApiResponse;
import umc.spring.apipayload.code.ReasonDto;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionAdvice {

    @ExceptionHandler(value = GeneralException.class)
    public ApiResponse<ReasonDto> handleGeneralException(GeneralException generalException) {
        ReasonDto reasonDto = generalException.getReason();
        return ApiResponse.onFailure(reasonDto.getCode(), reasonDto.getMessage(), null);
    }

}
