package umc.spring.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {

    public MemberMissionHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }

}
