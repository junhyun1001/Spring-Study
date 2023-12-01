package umc.spring.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }

}
