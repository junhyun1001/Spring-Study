package umc.spring.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }

}
