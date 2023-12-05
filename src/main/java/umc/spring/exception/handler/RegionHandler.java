package umc.spring.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.GeneralException;

public class RegionHandler extends GeneralException {

    public RegionHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }

}
