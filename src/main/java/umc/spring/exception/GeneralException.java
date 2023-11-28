package umc.spring.exception;

import lombok.AllArgsConstructor;
import umc.spring.apipayload.code.BaseCode;
import umc.spring.apipayload.code.ReasonDto;

@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseCode baseCode;

    public ReasonDto getReason() {
        return baseCode.getReason();
    }

}
