package com.project.weatherapi.exception;

import com.project.weatherapi.common.CommonException;
import com.project.weatherapi.constant.ErrorCodes;

public class CityNotFoundWithNameException extends CommonException {
    public CityNotFoundWithNameException() {
        super("No city found with given name!\"", ErrorCodes.CITY_NOT_FOUND_WITH_NAME_EXCEPTION);
    }
}
