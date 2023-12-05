package umc.spring.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }

}
