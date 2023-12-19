package umc.spring.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }

}
