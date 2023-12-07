package umc.spring.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }

}
