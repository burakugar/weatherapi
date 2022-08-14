package com.project.weatherapi.exception;

import com.project.weatherapi.common.CommonException;
import com.project.weatherapi.constant.ErrorCodes;

public class CityNotFoundWithIdException extends CommonException {
    public CityNotFoundWithIdException() {
        super("No city found with given id!\"", ErrorCodes.CITY_NOT_FOUND_WITH_ID_EXCEPTION);
    }
}
