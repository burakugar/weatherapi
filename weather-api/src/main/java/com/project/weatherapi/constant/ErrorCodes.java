package com.project.weatherapi.constant;

public final class ErrorCodes {
    private ErrorCodes() {
        throw new IllegalStateException("Constant Class");
    }

    public static final Integer CITY_NOT_FOUND_WITH_ID_EXCEPTION = 19998;
    public static final Integer CITY_NOT_FOUND_WITH_NAME_EXCEPTION = 19996;
    public static final Integer VALIDATION_CONSTRAINT_ERROR = 19996;
    public static final Integer FEIGN_CLIENT_ERROR = 19997;
    public static final Integer UNKNOWN_ERROR = 19999;
}
